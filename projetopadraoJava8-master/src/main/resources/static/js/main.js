$('document').ready(function(){
    $('.table .btn').on('click', function(event){

        event.preventDefault();

        var href= $(this).attr('href');

        $.get(href, function(alimento, status){
            $('#valorUnitarioEdit').val(alimento.valorUnitario);
            $('#formaDePagamentoEdit').val(alimento.formaDePagamento);
            $('#dataEdit').val(alimento.data);

        });


        $('#editModal').modal();
    });
});