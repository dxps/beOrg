define([],function(){

	var views = [
		{ value:"Common Settings", 	 id:"settings-common",   href:"#!/app/settings/settings-common", 	icon:"cog" },
		{ value:"Personal Settings", id:"settings-personal", href:"#!/app/settings/settings-personal", 	icon:"home" },
	];

	var menu = {
		view:"tabbar", id:"settings:menu",
		options:views, optionWidth:250,
		click:function(id){
			this.$scope.show("./"+this.getValue())
		}
	};

	var ui = {
		rows:[
			menu,
			{ $subview:true }
		]
	};

	return {
		$ui: ui,
		$menu: "settings:menu"
	};
});