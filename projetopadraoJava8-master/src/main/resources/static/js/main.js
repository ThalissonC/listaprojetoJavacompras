//$('document').ready(function(){
//    $('.table .btn').on('click', function(event){
//
//        event.preventDefault();
//
//        var href= $(this).attr('href');
//
//        $.get(href, function(alimento, status){
//            $('#idEdit').val(alimento.id);
//            $('#nomeEdit').val(alimento.nome);
//            $('#quantidadeEdit').val(alimento.quantidade);
//            $('#dataEdit').val(alimento.data);
//
//        });
//
//
//        $('#editModal').modal();
//    });
//});

document.addEventListener("DOMContentLoaded" , function(event) {

    $('.table .btn').on('click', function(event){
        event.preventDefault();

        var id = $(this).attr('href').split('?')[1].split('=')[1];

        const resp = $.getJSON(`/api/alimentos/alimento/${id}`);
        resp.then( r => {
           console.log( r );

           $("#idEdit").val(r.id);
           $("#nomeEdit").val(r.nome);
           $("#quantidadeEdit").val(r.quantidade);
           $("#valorUnitarioEdit").val(r.valorUnitario);
           $("#dataEdit").val(r.data);

        });

        }
    )
 });


 function updateAlimento (event){

    const id = $("#idEdit").val();
    const nome = $("#nomeEdit").val();
    const quantidade = $("#quantidadeEdit").val();
    const valor = $("#valorUnitarioEdit").val();
    const data = $("#dataEdit").val();

    const dados = {"id":id, "nome":nome, "quantidade":quantidade, "valorUnitario":valor, "data":data}

    console.log(dados);


    const apiUrl = `/api/alimentos/alimento/${id}`;

    $.ajax({
        contentType: "application/json; charset=uft-8",
        url: apiUrl,
        type: "PUT",
        dataType: "json",
        data: JSON.stringify(dados),
        contentType: "application/json",
        success: function(resp) {
            console.log(resp);
            window.location.reload();
        },
        error: function(error) {
            console.log(error);
        }
    })
 }

 function deleteAlimento (event){

     const id = $("#idEdit").val();
     const nome = $("#nomeEdit").val();
     const quantidade = $("#quantidadeEdit").val();
     const data = $("#dataEdit").val();

     const dados = {"id":id, "nome":nome, "quantidade":quantidade, "data":data}

     console.log(dados);


     const apiUrl = `/api/alimentos/alimento/${id}`;

     $.ajax({
         contentType: "application/json; charset=uft-8",
         url: apiUrl,
         type: "DELETE",
         dataType: "json",
         data: JSON.stringify(dados),
         contentType: "application/json",
         success: function(resp) {
             console.log(resp);
             window.location.reload();
         },
         error: function(error) {
             console.log(error);
             window.location.reload();
         }
     })
  }



