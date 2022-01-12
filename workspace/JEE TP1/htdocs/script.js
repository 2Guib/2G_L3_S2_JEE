let proverbeArea;

function getParam(param){
	return new URLSearchParams(window.location.search).get(param);
}

function onLoad()
{
	urlDistante = "proverbe"
	numero = getParam("num");
	if (numero)
	{
		urlDistante = urlDistante + "?num="+numero
	}
	proverbeArea = document.getElementById("proverbe");
    getFromServeurAndUpdate(urlDistante)	
}

function click() {
	alert("click");
	maj();
}

function maj(){
  getFromServeurAndUpdate("proverbe")
}

function getFromServeurAndUpdate(urlDistante)
{
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     proverbeArea.innerHTML = this.responseText;
    }
  };
   
  xhttp.open("GET", urlDistante, true);
  xhttp.send();
	
}