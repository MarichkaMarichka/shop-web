function NewAdd(index) {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (xhttp.readyState == 4 && xhttp.status == 200) {
      deleteTableItem(index);
    }
  };
  xhttp.open("GET", "NewAdd?index="+index, true);
  xhttp.send();
}
function deleteTableItem(index){
	var table = document.getElementById("table").deleteRow(index+1);
}