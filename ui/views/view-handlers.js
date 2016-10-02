define([
        "models/records"
    ],
    function (records) {

        var popup, eventId;

        var ui = { view: "datatable", autoConfig: true, scrollX: false, editable: true };

        return {

            /* ui config */
            $ui: ui,

            /* called right after view creation */
            $oninit: function (view) {

                popup = webix.ui({
                    view: "popup",
                    position: "center",
                    body: "Data is updated"
                });

                eventId = records.data.attachEvent("onDataUpdate", function () {
                    popup.show();
                });

                view.parse(records.data);

                console.log('>>> $oninit > created popup, registered to onDataUpdate event (eventId:'+eventId+').');
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
            },

            /* called before destroying the view */
            $ondestroy: function () {
                popup.destructor();
                records.data.detachEvent(eventId);
                console.log('>>> $ondestroy > destroyed popup, detached from onDataUpdate event.');
            }

        }

    }
);