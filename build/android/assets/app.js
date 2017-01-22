var db=Ti.Database.open('Notas');
var query = 'CREATE TABLE IF NOT EXISTS notas (id_nota INTEGER PRIMARY KEY AUTOINCREMENT,nota TEXT, fecha DATETIME DEFAULT CURRENT_TIMESTAMP, titulo TEXT,color COLOR);';
	db.execute(query);
	db.close();

var tabGroup = Ti.UI.createTabGroup(); 
	win_notas = Ti.UI.createWindow({
	url:'./notas.js'
	});

var tab_notas = Ti.UI.createTab({ 
	window:win_notas,
	title:'Block de notas'
}); 

tabGroup.addTab(tab_notas); 
tabGroup.open();
