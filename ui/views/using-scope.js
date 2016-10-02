define([
        "models/records"
    ],
    function (records) {

        var popup;

        var ui = { view: "datatable", autoConfig: true, scrollX:false, editable: true };

        return {

            /* ui config */
            $ui: ui,

            /* called right after view creation */
            $oninit: function (view, $scope) {

                popup = $scope.ui({
                    view: "popup",
                    width: 200,
                    height: 60,
                    css: "dataLoadingPopup",
                    position: "center",
                    body: "Data is updated"
                });

                $scope.on(records.data, "onDataUpdate", function (/* id, data */) {
                    // called when data item is in update process
                    // id = id of the item   (id)
                    // data = new data hash  (object)
                    popup.show();
                    setTimeout(function () { popup.close(); }, 2000);
                });

                view.parse(records.data);

                console.log('>>> $oninit > created popup, registered to onDataUpdate event of records.data.');

            },

            /* called when "local" URL is changed */
            /* args:
             *   config = parameters of the URL
             *   url = contains the segments and the parameters of the URL
             *   $scope = the current scope
             */
            $onurlchange:function (config, url, $scope) {
                console.log('>>> $onurlchange > url is ', url);
                console.log('>>> $onurlchange > config is ', config);
                console.log('>>> $onurlchange > $scope is ', $scope);
                $$('top:menu').select($scope.name);
            },

            /* called before destroying the view */
            $ondestroy: function () {
                // Nothing to do since $scope is used.
                // popup.destructor();
                // records.data.detachEvent(eventId);
                // console.log('>>> $ondestroy > destroyed popup, detached from onDataUpdate event.');
            }

        }

    }
);
