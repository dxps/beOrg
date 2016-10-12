define(function () {

    return {

        $ui: {
            view: "popup", id: "searchPopup",
            width: 300,
            body: {
                rows: [
                    {
                        view: "search", id: "searchField"
                    }
                ]

            }
        },

        vsvInit: function() {
            console.log("dbg | search vsvInit > called");
            $$('searchPopup').attachEvent("onShow", function() {
                console.log("dbg | search onShow ");
                $$('searchField').focus();
            });
        }

    };

});
