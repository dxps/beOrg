define([], function () {

    var views = [
        { value: "Personal",    id: "personal",    href: "./settings.personal",    icon: "home" },
        { value: "Application", id: "application", href: "./settings.application", icon: "home" }
    ];

    var settingsTopMenu = {
        view: "tabbar",
        id: "settings:menu",
        options: views,
        optionWidth: 150,
        click: function (id) {
            // this.$scope.show("./" + this.getValue());
            var settingsMenuItem = this.getValue();
            var settingsMenuItemIdx = this.optionIndex(settingsMenuItem);
            console.log('settingsTopMenu click(' + id + '): this.getValue() => ' + settingsMenuItem);
            console.log('settingsTopMenu click(' + id + '): this.optionIndex(' + settingsMenuItem + ') => ' + settingsMenuItemIdx);
            this.$scope.show(views[settingsMenuItemIdx].href);
        }
    };

    var ui = {
        rows: [
            settingsTopMenu,
            { $subview: true }
        ]
    };

    return {
        $ui: ui,
        $menu: "settings:menu"
    };

});
