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

        const resp = $.getJSON(`/alimento/${id}`);
        resp.then( r => {
           console.log( r );

           $("#idEdit").val(r.id);

        });

        }
    )
 });



