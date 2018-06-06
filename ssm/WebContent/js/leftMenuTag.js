var __thirdMenu = "";
$(document).ready(function() {
	if (__allTree == "true") {
		var __title = "";
		if (__selectMenuInfo != "") {
			var selectInfos = eval(__selectMenuInfo);
			for (var i = 0; i < selectInfos.length; i++) {
				var menuinfo = selectInfos[i];
				var layer = menuinfo.layer;
				if (layer == "1") {
					$("a[menuInfo='" + layer + "_" + menuinfo.code + "']").attr("class", "top-selected")
				} else {
					if (layer == "3") {
						__title = $("#" + menuinfo.code).html()
					} else {
						if (layer == "4") {
							__title = $($("div[menuInfo='" + layer + "_" + menuinfo.code + "']").children("a")[0]).html()
						}
					}
				}
			}
		}
		__createFourMenuTree();
		$(".ui-layout-west").css("overflow", "auto")
	} else {
		var temp = false;
		var __title = "";
		if (__selectMenuInfo != "") {
			var selectInfos = eval(__selectMenuInfo);
			for (var i = 0; i < selectInfos.length; i++) {
				var menuinfo = selectInfos[i];
				var layer = menuinfo.layer;
				if (layer == "1") {
					$("a[menuInfo='" + layer + "_" + menuinfo.code + "']").attr("class", "top-selected")
				} else {
					if (layer == "2") {
						$.each($("li[menuInfo='" + layer + "_" + menuinfo.code + "']"), function(i, n) {
							if (i == 1 && !temp) {
								$(n).attr("class", "sec-selected");
								temp = true
							}
						})
					} else {
						if (layer == "3") {
							__thirdMenu = menuinfo.code;
							var classes = $("#" + __thirdMenu).parent().attr("class");
							if (typeof(classes) != "undefined" && classes.indexOf("west-notree") >= 0) {
								$("div.west-notree-selected").removeClass("west-notree-selected");
								$("#" + __thirdMenu).parent().addClass("west-notree-selected")
							}
							__title = $("#" + __thirdMenu).html()
						} else {
							if (layer == "4") {
								var ___fourMenus = $("#div_" + __thirdMenu).children(".four-menu");
								if (___fourMenus.length > 0) {
									if ($(___fourMenus[0]).attr("iMatrixType") != "fourMenuPlaceholder") {
										$("div[menuInfo='" + layer + "_" + menuinfo.code + "']").attr("class", "four-menu-selected");
										__title = $($("div[menuInfo='" + layer + "_" + menuinfo.code + "']").children("a")[0]).html()
									}
								}
							}
						}
					}
				}
			}
		}
		if (__thirdMenu != "") {
			__initAccordion();
			if (__showZtree == "true") {
				__createFourMenuTree()
			} else {
				___replaceFourMenuPlaceholder(__thirdMenu, __iframeName);
				var __url_org = window.location.href;
				__url = __url_org.toLowerCase();
				if (__url.indexOf("_src_path_") < 0) {
					var defaultUrl = __getDefaultUrl(___thirdMenuCode);
					if (defaultUrl != "") {
						__firstAuthMenuUrl = defaultUrl
					}
					if (__firstAuthMenuUrl != "") {
						if (typeof(__tabable) != "undefined" && __tabable == "true") {
							iMatrix.addTab(__firstAuthMenuUrl, __title)
						} else {
							var iframes = $("iframe[name=" + __iframeName + "]");
							$(iframes[0]).attr("src", __firstAuthMenuUrl)
						}
					}
				}
			}
		}
	}
	dealWithUrlWhenIntegration(__title);
	packageChildMenus()
});

function dealWithUrlWhenIntegration(f) {
	var e = window.location.href;
	__url = e.toLowerCase();
	if (__url.indexOf("_src_path_") >= 0) {
		var c = __url.substring(__url.indexOf("_src_path_") + 10);
		if (c.indexOf("&") > 0) {
			c = c.substring(c.indexOf("=") + 1, c.indexOf("&"))
		} else {
			c = c.substring(c.indexOf("=") + 1)
		}
		var b = /~-/g;
		c = c.replace("~~", "?").replace(b, "&");
		var d = $("iframe[name=" + __iframeName + "]");
		if (d.length > 0) {
			var a = "";
			if (c.indexOf("http://") >= 0 || c.indexOf("https://") >= 0) {
				a = c
			} else {
				a = __webapp + c
			}
			if (typeof(__tabable) != "undefined" && __tabable == "true") {
				iMatrix.addTab(a, f)
			} else {
				$(d[0]).attr("src", a)
			}
		}
	}
}
function packageChildMenus() {
	if ($("#sysTableDivChildren").attr("id") != "sysTableDivChildren") {
		var f = "<div id='sysTableDivChildren'><table id='systemTableChildren'></table></div>";
		$("body").append(f)
	}
	var e = $("#__childrenMenus div");
	var g = [];
	for (var d = 0; d < e.length; d++) {
		var a = $(e[d]).attr("parentCode");
		var b = $(e[d]).html();
		if ($("#" + a + "-children").attr("id") != a + "-children") {
			var f = "<table id='" + a + "-children' style='display:none;'><tbody></tbody></table>";
			$("body").append(f)
		}
		var c = $("#" + a + "-children").find("tbody");
		$(c).append("<tr><td></td></tr>");
		$(c).find("tr:last").find("td").append(b);
		if (!__isContainMenu(g, a)) {
			g.push(a)
		}
	}
	bindMenuGroupHoverEvent(g)
}
function bindMenuGroupHoverEvent(f) {
	if (typeof(f) == "undefined") {
		var d = $("#__childrenMenus div");
		f = [];
		for (var b = 0; b < d.length; b++) {
			var a = $(d[b]).attr("parentCode");
			if (!__isContainMenu(f, a)) {
				f.push(a)
			}
		}
	}
	for (var b = 0; b < f.length; b++) {
		var g = $("a[menuInfo='1_" + f[b] + "']").attr("class");
		if (typeof(g) != "undefined" && g.indexOf("parent_sys") < 0) {
			if (g == "standardSys") {
				g = ""
			}
			var e = "parent_sys";
			var c = $("a[menuInfo='1_" + f[b] + "']").attr("isInMore");
			if (c == "true") {
				e = "parent_sys_inmore"
			}
			if (g != "") {
				$("a[menuInfo='1_" + f[b] + "']").attr("class", g + " " + e)
			} else {
				$("a[menuInfo='1_" + f[b] + "']").attr("class", e)
			}
		}
		$("a[menuInfo='1_" + f[b] + "']").hover(function(k) {
			var j = $(this).attr("menuInfo");
			var h = j.substring(j.indexOf("_") + 1);
			var i = $("a[menuInfo='1_" + h + "']").attr("isInMore");
			if (i == "false") {
				$("#systemTableChildren").attr("parentCode", h);
				$("#systemTableChildren").html($("#" + h + "-children").html());
				__showMenu($(this))
			}
		}, function(h) {
			$("#sysTableDivChildren").hide();
			$("#sysTableDivChildren").hover(function(k) {
				var i = $("#systemTableChildren").attr("parentCode");
				var j = $("a[menuInfo='1_" + i + "']").attr("isInMore");
				if (j == "false") {
					__showMenu($("a[menuInfo='1_" + i + "']"))
				}
			}, function(i) {
				$("#sysTableDivChildren").hide()
			})
		})
	}
}
function __showMenu(b) {
	$("#sysTableDivChildren").show();
	var a = b.position();
	var c = b.offset();
	var d = b.attr("class");
	if (d.indexOf("top-selected") >= 0) {
		$("#sysTableDivChildren").css("top", (a.top + b.height()) + "px")
	} else {
		$("#sysTableDivChildren").css("top", (a.top + b.height() - 1) + "px")
	}
	$("#sysTableDivChildren").css("left", c.left + "px");
	__selectSubSystem()
}
function __isContainMenu(c, b) {
	for (var a = 0; a < c.length; a++) {
		if (c[a] == b) {
			return true
		}
	}
	return false
}
function __selectSubSystem() {
	if (_subSysMenuInfo != "") {
		var a = $("#sysTableDivChildren a[menuInfo='1_" + _subSysMenuInfo + "']").attr("class");
		if (a == "" || typeof(a) == "undefined") {
			$("#sysTableDivChildren a[menuInfo='1_" + _subSysMenuInfo + "']").attr("class", "sys_selected")
		} else {
			if (a.indexOf("sys_selected") < 0) {
				$("#sysTableDivChildren a[menuInfo='1_" + _subSysMenuInfo + "']").attr("class", a + " sys_selected")
			}
		}
	}
}
var ___thirdMenuCode = "";

function __initAccordion() {
	$("#__accordion").accordion({
		fillSpace: true,
		active: __getIndex("#__accordion"),
		change: function(e, f) {
			var d = $($(f.newHeader[0]).children()[1]);
			var a = d.attr("href");
			___thirdMenuCode = d.attr("id");
			var g = d.html();
			var c = d.attr("target");
			if (typeof(c) != "undefined" && c != "") {
				__initFourMenuTree(a, g, c)
			} else {
				if (__changeType == "zone") {
					var b = __getDefaultUrl(___thirdMenuCode);
					if (b != "") {
						a = b
					}
					ajaxSubmit("defaultForm", a, "mainZone", __initFourMenuTree)
				} else {
					location.href = a
				}
			}
		}
	})
}
function __initFourMenuTree(__url, __title, ___thirdMenuIframeName) {
	var rootUrl = webRoot;
	if (typeof(appRoot) != "undefined" && appRoot != "") {
		rootUrl = appRoot
	}
	$.ajax({
		data: {
			thirdMenuCode: ___thirdMenuCode,
			companyId: $("#_iMatrix_company_id").val(),
			tabable: __tabable
		},
		cache: false,
		type: "post",
		url: rootUrl + "/portal/refreshMenu.action",
		success: function(data, textStatus) {
			if (data != "") {
				__menuId = "";
				var isTree = data.substring(0, data.indexOf(":"));
				var menuInfo = data.substring(data.indexOf(":") + 1);
				if (isTree == "true") {
					__fourMenuTreeDatas = eval(menuInfo);
					if ($("#__fourmenuTree").attr("id") != "__fourmenuTree") {
						$("#div_" + ___thirdMenuCode).html('<div id="__fourmenuTree" class="ztree" style="background: none;"></div>')
					}
					__myCreateFourMenuTree();
					__selectFirstMenuNode()
				} else {
					$("#div_" + ___thirdMenuCode).html(menuInfo);
					var ___fourMenus = $("#div_" + ___thirdMenuCode).children(".four-menu");
					if (___fourMenus.length > 0) {
						if ($(___fourMenus[0]).attr("iMatrixType") == "fourMenuPlaceholder") {
							___replaceFourMenuPlaceholder(___thirdMenuCode, ___thirdMenuIframeName)
						} else {
							$(___fourMenus[0]).attr("class", "four-menu-selected");
							__title = $($(___fourMenus[0]).children("a")[0]).html()
						}
					}
					if (__changeType != "zone") {
						if (typeof(__tabable) != "undefined" && __tabable == "true") {
							var __url_temp = $($(___fourMenus[0]).children("a")[0]).attr("menuUrl");
							if (typeof(__url_temp) != "undefined") {
								__url = __url_temp
							}
							iMatrix.addTab(__url, __title)
						} else {
							var iframes = $("iframe[name=" + ___thirdMenuIframeName + "]");
							if (iframes.length > 0) {
								var defaultUrl = __getDefaultUrl(___thirdMenuCode);
								if (defaultUrl != "") {
									__url = defaultUrl
								} else {
									var __url_temp = $($(___fourMenus[0]).children("a")[0]).attr("href");
									if (typeof(__url_temp) != "undefined") {
										__url = __url_temp
									}
								}
								$(iframes[0]).attr("src", __url)
							}
						}
					}
				}
			}
		},
		error: function() {}
	})
}
function __getIndex(d) {
	var b = $(d).children("h3");
	for (var a = 0; a < b.length; a++) {
		var c = $($(b[a]).children("a")[0]).attr("id");
		if (__thirdMenu == c) {
			return a
		}
	}
	return 0
}
function __myCreateFourMenuTree() {
	var a = {
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			onClick: __onClick
		}
	};
	$.fn.zTree.init($("#__fourmenuTree"), a, __fourMenuTreeDatas)
}
function __createFourMenuTree() {
	__myCreateFourMenuTree();
	__getMenuSelectNode()
}
function __onClick(event, treeId, treeNode) {
	var childrenNodes = treeNode.children;
	if (childrenNodes != null) {
		var treeObj = $.fn.zTree.getZTreeObj("__fourmenuTree");
		treeObj.expandNode(treeNode, true);
		return
	}
	var treedata = eval(treeNode.data);
	var menu = treedata[0];
	if (menu.externalable) {
		window.open(menu.menuUrl + "?menuId=" + menu.id, "write")
	} else {
		var url = menu.menuUrl + "?menuId=" + menu.id;
		var ___thirdMenuIframeName = __iframeName;
		if (typeof(___thirdMenuIframeName) != "undefined" && ___thirdMenuIframeName != "" && ___thirdMenuIframeName != "null") {
			var iframes = $("iframe[name=" + ___thirdMenuIframeName + "]");
			if (iframes.length > 0) {
				if (typeof(__tabable) == "undefined" || __tabable == "false") {
					$(iframes[0]).attr("src", url);
					return
				}
			}
			if (typeof(__tabable) != "undefined" && __tabable == "true") {
				var url = menu.menuUrl + "?menuId=" + menu.id;
				iMatrix.addTab(url, menu.name)
			}
		} else {
			if (__changeType == "zone") {
				ajaxSubmit("defaultForm", url, "mainZone")
			} else {
				window.location.href = url
			}
		}
	}
}
function __getMenuSelectNode() {
	var c = $.fn.zTree.getZTreeObj("__fourmenuTree");
	if (c != null && typeof(c) != "undefined") {
		var a = c.getNodes();
		var b = c.getNodesByFilter(function(d) {
			if (d.id == __menuId) {
				return true
			}
			return false
		}, true);
		if (b == null) {
			__selectFirstMenuNode()
		} else {
			c.selectNode(b);
			__onClick("", "__fourmenuTree", b)
		}
	}
}
function __selectFirstMenuNode() {
	var d = null;
	var c = $.fn.zTree.getZTreeObj("__fourmenuTree");
	if (c != null && typeof(c) != "undefined") {
		var a = c.getNodes();
		for (var b = 0; b < a.length; b++) {
			d = ____getFirstSelectChildNode(a)
		}
	}
	if (d != null) {
		c.selectNode(d);
		if (d != null) {
			c.selectNode(d);
			__onClick("", "__fourmenuTree", d)
		}
	}
}
function ____getFirstSelectChildNode(a) {
	for (var c = 0; c < a.length; c++) {
		var b = a[c].children;
		if (b == null || b.length <= 0) {
			return a[c]
		} else {
			return ____getFirstSelectChildNode(b)
		}
	}
}
function ___replaceFourMenuPlaceholder(thirdMenuCode, _iframeName) {
	var placeholders = $("#div_" + thirdMenuCode).find("div.four-menu-placeholder");
	if (typeof(placeholders) != "undefined" && placeholders.length > 0) {
		placeholders.each(function(index) {
			var fourMenuName = $(this).attr("name");
			var fourMenuInfo = $replaceFourMenuPlaceholder(fourMenuName);
			if (typeof(fourMenuInfo) == "object") {
				$(this).before(fourMenuInfo.html);
				eval(fourMenuInfo.script)
			} else {
				$(this).before(fourMenuInfo)
			}
			$(this).remove()
		})
	}
}
function $replaceFourMenuPlaceholder(b, a) {
	return ""
}
function __getDefaultUrl(b) {
	var a = $("#div_" + b).children(".four-menu");
	if (a.length > 0) {
		if ($(a[0]).attr("iMatrixType") == "fourMenuPlaceholder") {
			return $returnDefaultUrl(b)
		}
	}
	return ""
}
function $returnDefaultUrl(a) {
	return ""
};