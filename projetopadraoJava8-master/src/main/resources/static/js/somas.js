
// function soma()  {
    var id = $(this).attr('href').split('?')[1].split('=')[1];
    console.log(id);

    const resp = $.getJSON(`/api/alimentos/alimento/${id}`);
    resp.then( r => {
       console.log( r );


       $("#valorUnitarioSoma").val(r.valorUnitario);

    });
//}