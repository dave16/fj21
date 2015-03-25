/**
 * 
 */
$(document).ready(function(){
	mascara();
	$("#datepicker").datepicker({dateFormat: 'dd/mm/yy'});
});


function excluir (id){
	if(confirm("Tem certeza que deseja excluir ?")){
		location.href = "/Fj21/mvc?logica=ExcluirContato&id=" + id;
	}
}

function mascara(){
	$("#dataNascimento").mask("99/99/9999");
}


