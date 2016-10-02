define([], function () {

    var ui = {
        rows: [
            {
                view:"toolbar", borderless:true,
                cols:[
                    { gravity: 4},
                    { view:"button", type:"icon", icon:"envelope", label:"News",
                        click: function () {
                            this.$scope.show("./news");
                        }
                    },
                    { view:"button", type:"icon", icon:"cog", label:"Data",
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
