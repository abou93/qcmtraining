function testTypeDate(dateEntree)
{
tst=false;
try
{rc=dateEntree.split("/");nd=new Date(rc[2],(rc[1]-1),rc[0]);
tst=(rc[2]>1800&&rc[2]<2200&&rc[2]==nd.getFullYear()&&rc[1]==(nd.getMonth()+1)&&rc[0]==nd.getDate());
} catch(e) {}
return tst;
}


function testTypeChiffre(valeurChamps){
	if (valeurChamps != '')
	{
		var ValidChars = "0123456789";
		var retour='';
		var Char;
	
		for (i = 0; i < valeurChamps.length ; i++)
		{
			Char = valeurChamps.charAt(i);
			if (ValidChars.indexOf(Char) == -1)
			{
				return false;
			
			}
		}
	}
	return true;
}

//pour la saisie des doubles (reprise de 20/200) ROPCOL-13

function entierKeyPress(field, evt) {

   return numericKeyPress(false, false, false, field, evt); 
}

function decimalKeyPress(field, evt) {

   return numericKeyPress(true, false, false, field, evt); 
}

function decimalSigneKeyPress(field, evt) {

	return numericKeyPress(true, false, true, field, evt);
}

function dateKeyPress(field, evt) {

   return numericKeyPress(false, true, false, field, evt); 
}

var date8ProtoRegexp = new RegExp(".*/.*/.*");

/**
 * Cette fonction interdit la saisie d'un caractère autre que numérique
 */ 
function numericKeyPress(decimal, date, signe, field, evt) {

	// Get ASCII value of key that user pressed
	var key = evt.keyCode || evt.which;
	// alert(decimal + ", " + date + ", key=" + key);
	
   // Was key that was pressed a numeric character (0-9)?
   if ( key==8 || key == 9 || key == 13 || key > 47 && key < 58 ) {

		if (date) {
			//var source = myEvent.srcElement;
			var valeur = field.value;
			var date8 = (field.maxLength >= 10);
			if(key==8) {
				return true;
			}
			if (valeur != null && valeur.length == 2 && valeur.indexOf("/") == -1) {
				field.value = valeur + "/";
			}
			if (date8 && valeur != null && 
				valeur.length == 5 && valeur.search(date8ProtoRegexp) == -1) {
				field.value = valeur + "/";
			}
		}
		return true; // if so, do nothing
      
   } else if (decimal) { // Numérique décimal
   		/*if (key == 44) { // Virgule remplacée par point
   			key = 46;
   			//LAM : 12-05-2006 : remplacer virgule par point
   			evt.keyCode = 46;
   		}*/
   		if (key == 44) { // virgule
	   		var valeur = field.value;
	   		if (valeur == null || valeur.indexOf(",") == -1) {
	   			return true;
		   	}
   		}
		else if (signe) { // Signe
			//if (field.value.length == 0) {
				if (key == 43 || key == 45 || key == 8) { // + et -
					return true;
				}
			//}
		}
   } else if (date) { // Date
   		if (key == 47 || key == 8) { // Slash
   			return true;
   		}
   }

   if(evt.preventDefault) {
      // sous firefox
      
	if(key == 37 || key == 39)
   		return true;

      if(key!=8) {
         // on laisse passer le retour arrière
         evt.preventDefault();
         evt.stopPropagation();
      }
   } else {
      // sous IE
      evt.keyCode = 0;
      evt.returnValue = 0;
   }
   
   return false;
}