define([
    "app",
    "libs/webix-jet-core/plugins/locale",
    "libs/webix-jet-core/plugins/theme"
], function (app, locales, themes) {


    var languages = [
        { id: "en", value: "English" },
        { id: "ro", value: "Română" }
    ];

    var lang_ui = {
        view: "segmented", name: "language", label: "Language",
        options: languages, optionWidth: 120,
        click: function () {
            locales.setLang(this.getValue());
        }
    };

    var themenames = [
        { id: "siberia:webix", value: "Siberia" },
        { id: "siberia:skins/compact", value: "Compact" }
    ];

    var skins_ui = {
        view: "segmented", name: "theme", label: "Theme",
        options: themenames, optionWidth: 120,
        click: function () {
            themes.setTheme(this.getValue());
        }
    };

    var personal = {
        view: "form", rows: [
            { type: "section", template: "Personal Settings" },
            lang_ui,
            skins_ui,
            {}
        ]
    };

    var view = {
        $ui: personal,
        $oninit: function (view) {
            view.elements.language.setValue(locales.getLang());
            view.elements.theme.setValue(themes.getThemeId());
        }
    };

    return view;
});
