$('document').ready(function(){
    $('.table .btn').on('click', function(event){

        event.preventDefault();

        var href= $(this).attr('href');

        $.get(href, function(alimento, status){
            $('#idEdit').val(alimento.id);
            $('#nomeEdit').val(alimento.nome);
            $('#quantidadeEdit').val(alimento.quantidade);
            $('#dataEdit').val(alimento.data);

        });


        $('#editModal').modal();
    });
});