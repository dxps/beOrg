define([
	"app"
],function(app){

	var header = {
		type:"header", template:app.config.name
	};

	var menu = {
		view:"menu", id:"top:menu",
		width:180, layout:"y", select:true,
		template:"<span class='webix_icon fa-#icon#'></span> #value# ",
		data:[
			{ value:"Home",      id:"home",     href:"#!/main/home",        icon:"envelope-o" },
			{ value:"Data",      id:"data",     href:"#!/main/data",        icon:"briefcase" },
			{ value:"Settings",  id:"settings",	href:"#!/main/settings/settings.personal", icon:"cog" },
			{ $template:"Separator" },
			{ value:"View Handlers",  id:"view-handlers",  href:"#!/main/view-handlers",  icon:"cog" },
			{ value:"Using $scope",  id:"using-scope",  href:"#!/main/using-scope",  icon:"cog" }
		]
	};

    var ui = {
        type: "clean",
		rows: [
			{ cols: [
				{
					type: "clean", css: "app-left-panel",
					padding: 0, margin: 0, borderless: true, rows: [ header, menu ]
				},
				{
					rows: [
						{ type: "clean", css: "app-right-panel", padding:0, margin:0,
						  rows: [
						  	{ $subview: true }
						  ]
						}
					]
				}
			  ]
			},
			{
				type: "template", template: "&copy; 2016", css: "app-footer-small", height: 24
			}
        ]
    };

	return {
		$ui: ui,
		$menu: "top:menu"
	};
});
