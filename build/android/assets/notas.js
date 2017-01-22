//CUADERNO DE NOTAS

	var win=Titanium.UI.currentWindow;
		win.title='Notas';
		
	var tabla=Titanium.UI.createTableView({
		backgroundColor:'#999',
		top:0,
		width:'100%',height:'80%',
		});

	var button=Ti.UI.createButton({
		title:'Añadir nueva nota',
		bottom:'1%',
		width:'90%', height:'20%',
		borderRadius:6,borderWidth:6,
		backgroundColor:'#336699',
		color:'#fff',
		font:{fontSize:16, fontWeight:'bold'}
		});

	win.add(tabla);
	win.add(button);

	//LAYOUT DEL FORMULARIO

	/*FUNCIÓN DEL BOTÓN*/

	button.addEventListener('click',function(e){
	
		var form_win=Titanium.UI.createWindow({
			title:'Crear nueva nota',
			width:'100%',height:'100%',
			backgroundColor:'#000',
			opacity:0.8
			});
	
		var view=Titanium.UI.createView({
			width:'80%',height:'80%',
			backgroundColor:'#fff',
			borderRAdius:6,
			borderWidth:6,
			borderColor:'#666'
			});

		var label=Titanium.UI.createLabel({
			text:'Introduce tu nota',
			top:16, left:'6%',
			color:'#000',
			font:{fontSize:18}
			});

		//TITULO
		var textarea=Titanium.UI.createTextArea({
			widht:'10%',
			color:'#000',
			top:10, bottom:24 
			});

		//CUERPO TEXTO
		var textarea2=Titanium.UI.createTextArea({
			widht:'92%',
			color:'#000',
			top:60, bottom:48
			});


		// AÑADIR LISTADO DE COLORES
	
		/*var picker=Titanium.UI.createPicker();
		var data = [];
			data[0]=Ti.UI.createPickerRow({id:'0', title:'First row'});
			data[1]=Ti.UI.createPickerRow({id:'1', title:'Second row'});
			data[2]=Ti.UI.createPickerRow({id:'2', title:'Third row'});
			picker.add(data);
			picker.getSelectedRow(0).id;*/


		//BOTÓN GUARDAR
		var guardar=Ti.UI.createButton({
			title:'Guardar',
			width:160, height:32,
			bottom:16,
			color:'#fff',
			borderRadius:6,
			borderWidth:6,
			backgroundColor:'#336699'
			});
		
	
		
	guardar.addEventListener('click', function(e) {
	guardarNota(textarea, form_win);
	//showDialog("Nota_insertada","Continue");
	});

	/*
	showDialog("Nota_insertada","Continue");
	});*/
	
	view.add(label);
	view.add(textarea);
	view.add(textarea2);
	view.add(guardar);
	//view.add(modificar);
	form_win.add(view);
	form_win.open({'modal':true});
});

cargaNotas();
//form_win.close();

//ORDENAR LISTADO DE LA PÁGINA PRINCIPAL

function cargaNotas(){
	var db=Ti.Database.open('Notas');
	var query='SELECT * FROM notas ORDER BY fecha DESC';
	var res=db.execute(query);
	var filas=[];
		while(res.isValidRow()){
			var fecha_txt=res.fieldByName('fecha');
			var nota_txt=res.fieldByName('nota');
			var fecha_label=Ti.UI.createLabel({
				text:fecha_txt,
				top:8,
				width:'90%', 
				height:18,
				color:'#000',
				font:{fontWeight:'bold',fontSize:16}
				});

			var nota_label=Ti.UI.createLabel({
				text:nota_txt,
				top:24,
				width:'90%',height:64,
				color:'#333',
				font:{fontWeight:'normal',fontSize:18}
				});

			var nota_view=Ti.UI.createView({
				width:'100%',height:88
				});

			nota_view.add(fecha_label);
			nota_view.add(nota_label);
			var fila_tabla=Ti.UI.createTableViewRow({
				selectedColor:'black',
				height:88
				});
		tabla.addEventListener('click',function(e){
				modificarNotas();			
		});
		
			fila_tabla.add(nota_view);
			filas.push(fila_tabla);
			res.next();
			}
		res.close();
		db.close();
		tabla.setData(filas);
	};

function showDialog(title,msg){
	
	if(!title)
		title = 'test';
		if(!msg)
		msg="No es posible";
		Ti.UI.createAlertDialog({
			title:title,
			message:msg,
			buttonNames:['OK']
		}).show();
}


function guardarNota(textarea, form_win){
		if(textarea.value<1){
			
			showDialog('Introduce tus notas'
					,'Debes de introducir alguna nota');
			return;
		}
		
	
		//guardar.addEventListener('click',function(e){
			//guardarNota(textarea,form_win);
			var db = Ti.Database.open('Notas');
			var query = 'INSERT INTO notas (nota) VALUES(?)';
			db.execute(query, textarea.value);
			var id_nota_current = db.lastInsertRowID;
			db.close();
			//});
		
		cargaNotas();
		form_win.close();
	}
		
	function modificarNotas(){
		var form_win=Titanium.UI.createWindow({
			title:'Modificar nueva nota',
			width:'100%',height:'100%',
			backgroundColor:'#000',
			opacity:0.8
			});
	
		var view=Titanium.UI.createView({
			width:'80%',height:'80%',
			backgroundColor:'#fff',
			borderRAdius:6,
			borderWidth:6,
			borderColor:'#666'
			});

		var label=Titanium.UI.createLabel({
			text:'Modifica tu nota',
			top:16, left:'6%',
			color:'#000',
			font:{fontSize:18}
			});

		//TITULO
		var textarea=Titanium.UI.createTextArea({
			widht:'10%',
			color:'#000',
			top:10, bottom:24 
			});

		//CUERPO TEXTO
		
		var textarea2=Titanium.UI.createTextArea({
			widht:'92%',
			color:'#000',
			top:60, bottom:48
			});
			
			var modifica=Ti.UI.createButton({
			title:'Modificar',
			width:160, height:32,
			bottom:16,
			color:'#fff',
			borderRadius:6,
			borderWidth:6,
			backgroundColor:'#336699'
			});
		modifica.addEventListener('click', function(e) {
		modifica_Nota(textarea, form_win);
		
	});
	
	view.add(label);
	view.add(textarea);
	view.add(textarea2);
	view.add(modifica);
	//view.add(modificar);
	form_win.add(view);
	form_win.open({'modal':true});
	}
	function modifica_Nota(textarea, form_win){
		if(textarea.value<1){
			
			showDialog('Introduce tus notas'
					,'Debes de introducir alguna nota');
			return;
		}

	var db=Ti.Database.open('Notas');
	//obtener los datos de la fecha y nota para meter en la bbdd
	var nota = tableview.data.rows;
	var query1='SELECT id_nota FROM notas WHERE nota=?';	
	var query='UPDATE Notas FROM notas SET nota =? WHERE id_nota=query1';
	var res=db.execute(query);
	var filas=[];
		while(res.isValidRow()){
			var fecha_txt=res.fieldByName('fecha');
			var nota_txt=res.fieldByName('nota');
			var fecha_label=Ti.UI.createLabel({
				text:fecha_txt,
				top:8,
				width:'90%', 
				height:18,
				color:'#000',
				font:{fontWeight:'bold',fontSize:16}
				});

			var nota_label=Ti.UI.createLabel({
				text:nota_txt,
				top:24,
				width:'90%',height:64,
				color:'#333',
				font:{fontWeight:'normal',fontSize:18}
				});

			var nota_view=Ti.UI.createView({
				width:'100%',height:88
				});

			nota_view.add(fecha_label);
			nota_view.add(nota_label);
			var fila_tabla=Ti.UI.createTableViewRow({
				selectedColor:'black',
				height:88
				});

			fila_tabla.add(nota_view);
			filas.push(fila_tabla);
			res.next();
			}
		res.close();
		db.close();
		tabla.setData(filas);
		form_win.close();
		
	};
