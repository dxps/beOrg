/*
	App configuration
*/

define([
	"libs/webix-jet-core/core",
	"libs/webix-jet-core/plugins/menu",
	"libs/webix-jet-core/plugins/skin"
], function(
	core, menu, skin
){

	// config
	var app = core.create({
		id:         "beorg-ui",
		name:       "beOrg UI",
		version:    "0.1.0",
		debug:      true,
		start:      "/top/start"
	});

	app.use(menu);

	app.use(skin);

	return app;
});
