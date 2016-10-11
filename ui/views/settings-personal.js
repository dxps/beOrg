define([
	"app",
	"libs/webix-jet-core/plugins/skin"
],function(app, skin){

	var skins = [
		{ id:"visva-material-clean:skins/visva-material-clean",  value:"Material Clean" },
		{ id:"compact:skins/compact",                            value:"Compact" },
		{ id:"mm1-compact:skins/mm1-compact",                    value:"Compact MM 1" }
	];
	var skins_ui = {
		view:"segmented", name:"skin", label:"Skin",
		options:skins, optionWidth:120,
		click:function(){ skin.setSkin(this.getValue()); }
	};

    var personal = { view:"form",
    	rows:[
    		{ type:"section", template:"App Settings" },
			skins_ui,
			{}
		]
	};

	var view = {
		$ui : personal,
		$oninit:function(view){
			console.log('settings-personal > $oninit > selecting the skin button based on skin.getSkinId():', skin.getSkinId());
			view.elements.skin.setValue( skin.getSkinId() );
		}
	};

	return view;
});
