define(function() {

    var key = ".skin";

    function _get_skin() {
        var data = (webix.storage.local.get(key) || "visva-material-clean:skins/visva-material-clean").split(":");
        return {
            file: data[1],
            name: data[0]
        };
    }

    function _set_skin(name, skin) {
        if (arguments.length == 1) {
            var parts = name.split(":");
            name = parts[0];
            skin = parts[1];
        }

        var now = _get_skin();
        if (now.skin != skin || now.name != name) {
            webix.storage.local.put(key, name + ":" + skin);
            document.location.reload();
        }
    }

    return {
        $oninit: function(app, config) {
            key = (app.config.id || "") + key;
        },

        setSkin: _set_skin,
        getSkin: _get_skin,
        getSkinId: function() {
            var skin = _get_skin();
            return skin.name + ":" + skin.file;
        }
    };
});
