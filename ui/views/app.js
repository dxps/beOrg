define([
    "views/header/search"
], function (search) {

    var topHeader = {
        view: "toolbar",
        elements: [
            {
                view: "label", width: 200,
                label: "<a href='/'><img class='photo' src='assets/logo/favicon32.png' /></a>"
            },
            {},
            { view: "icon", icon: "search", width: 45, popup: "searchPopup" },
            { view: "icon", icon: "envelope-o", value: 3, width: 45, popup: "mailPopup" },
            { view: "icon", icon: "comments-o", value: 5, width: 45, popup: "messagePopup" }
        ]
    };

    var body = {
        rows: [
            {
                height: 49, id: "title", css: "title",
                template: "<div class='header'>#title#</div><div class='details'>( #details# )</div>", data: { text: "", title: "" }
            },
            {
                view: "scrollview", scroll: "native-y",
                body: { cols: [{ $subview: true }] }
            }
        ]
    };

    var ui = {
        rows: [
            topHeader,
            body
        ]
    };

    return {
        $ui: ui,
        $menu: "top:menu",
        $oninit: function (view, scope) {
            scope.ui(search.$ui);
            search.vsvInit();
        }
    };
});
