define([], function () {

    var ui = {
        rows: [
            {
                template: "Home page", height: 32
            },
            {
                view: "toolbar", height: 36, elements: [
                {},
                {
                    view: "button", width: 200, value: "Show the news",
                    click: function () {
                        this.$scope.show("./news");
                    }
                },
                {
                    view: "button", width: 200, value: "Go to the data page",
                    click: function () {
                        this.$scope.show("data");
                    }
                }
            ]
            },
            { $subview: true }
        ]
    };

    return ui;

});
