var __thirdMenu = "";
$(document).ready(function() {
	var temp = false;
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
						__thirdMenu = menuinfo.code
					} else {
						if (layer == "4") {
							$("div[menuInfo='" + layer + "_" + menuinfo.code + "']").attr("class", "four-menu-selected")
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
		}
	}
});
var ___thirdMenuCode = "";

function __initAccordion() {
	$("#__accordion").accordion({
		fillSpace: true,
		active: __getIndex("#__accordion"),
		change: function(d, e) {
			var c = $($(e.newHeader[0]).children()[1]);
			var a = c.attr("href");
			___thirdMenuCode = c.attr("id");
			var b = c.attr("target");
			var f = $("iframe[name=" + b + "]");
			if (typeof(b) != "undefined" && b != "" && f.length > 0) {
				$(f[0]).attr("src", a);
				__initFourMenuTree()
			} else {
				if (__changeType == "zone") {
					ajaxSubmit("defaultForm", a, "mainZone", __initFourMenuTree)
				} else {
					location.href = a
				}
			}
		}
	})
}
function __initFourMenuTree() {
	var rootUrl = webRoot;
	if (typeof(appRoot) != "undefined" && appRoot != "") {
		rootUrl = appRoot
	}
	$.ajax({
		data: {
			thirdMenuCode: ___thirdMenuCode,
			companyId: $("#_iMatrix_company_id").val()
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
					$("#div_" + ___thirdMenuCode).html(menuInfo)
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
	var treedata = eval(treeNode.data);
	var menu = treedata[0];
	if (menu.externalable) {
		window.open(menu.menuUrl + "?menuId=" + menu.id, "write")
	} else {
		var url = menu.menuUrl + "?menuId=" + menu.id;
		var ___thirdMenuIframeName = __iframeName;
		var iframes = $("iframe[name=" + ___thirdMenuIframeName + "]");
		if (typeof(___thirdMenuIframeName) != "undefined" && ___thirdMenuIframeName != "" && ___thirdMenuIframeName != "null" && iframes.length > 0) {
			$(iframes[0]).attr("src", url)
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
		c.selectNode(b)
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
		c.selectNode(d)
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
};