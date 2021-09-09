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

//function verificaCheck(){
//var verificaCheckBox = document.getElementsByName("check").textContent
//    if(verificaCheckBox.checked){
//        alert("checkbox marcada")
//    }
//}

alert

// Definir data atual da adição do item a lista
var data = new Date();
var dia = data.getDate();  // 1-31
var mes = data.getMonth(); // 0-11 (zero=janeiro)
var ano4 = data.getFullYear(); // 4 dígitos

var str_data = dia + '/' + (mes+1) + '/' + ano4;


// Ação que preenche o MODAL de Edição com as informações do item clicado

document.addEventListener("DOMContentLoaded" , function(event) {

    $('.table .btn').on('click', function(event){
        event.preventDefault();

        var id = $(this).attr('href').split('?')[1].split('=')[1];

        const resp = $.getJSON(`/api/alimentos/alimento/${id}`);
        resp.then( r => {
           console.log( r );

           $("#idEdit").val(r.id);
           $("#nomeEdit").val(r.nome);
           $("#categoriaEdit").val(r.categoria);
           $("#quantidadeEdit").val(r.quantidade);
           $("#valorUnitarioEdit").val("R$" + r.valorUnitario);
           $("#dataEdit").val(r.data);


           var formatarValorEmReal = document.getElementById("valorUnitarioEdit").toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' });

        });

        }
    )
 });

document.addEventListener("DOMContentLoaded" , function(event) {

    $('.table .fw-bold').on('click', function(event){
        event.preventDefault();

        var id = $(this).attr('href').split('?')[1].split('=')[1];

        const resp = $.getJSON(`/api/alimentos/comprados/alimento/${id}`);
        resp.then( r => {
           console.log( r );

           $("#idEdit").val(r.id);
           $("#nomeEdit").val(r.nomeItemComprado);
           $("#categoriaEdit").val(r.categoria);
           $("#quantidadeEdit").val(r.quantidadeItemComprado);
           $("#valorUnitarioEdit").val(r.valorUnitarioItemComprado);
           $("#dataEdit").val(r.dataItemComprado);


           var formatarValorEmReal = document.getElementById("valorUnitarioEdit").toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' });

        });

        }
    )
 });



//Tornar botão de salvar confirmação de compra visível
var botaoVisivel = document.getElementsByName("checks");
for(var i = 0; i < botaoVisivel.length; i++){
      if(botaoVisivel[i].checked){
        alert("executado")
        var marcarCompra = documento.getElementById("btMarcarCompra");
        marcarCompra.classList.remove('hidden');
      }
}

// Ação através da marcação das CheckBox
//
function exibir(){
    var texto = "As caixas selecionadas são:\n\n";
    var boxes = document.getElementsByName("checks"); // Variável usada para comparação no [for] se as checkBox foram marcadas ou não.
    var attrbComprado;
    const id = $("#idEdit").val(); // Captura a Id atual do item adicionado e adicion a variável id.

    attrbComprado = document.getElementById("compradoEdit").value = "sim"; //Atribui o valor do input do modal chamado de --> comprado, para = "sim".

    const comprado = $("#compradoEdit").val(); //Captura o atual valor presente no input chamado Comprado do EditModal (Esperado: "Sim").
    const dados = {"id":id, "comprado":comprado} // Variável que armazena os valores a serem enviados para a api em um objeto.
    const apiUrl = `/api/alimentos/alimentoComprado/${id}`;

    console.log(dados);

    // [for] que percorre as checkbox verificando quais estão marcadas, em seguidaa executa script
    for(var i = 0; i < boxes.length; i++){
      if(boxes[i].checked){
                // Texto que exibe quais checkbox foram marcadas
              console.log(attrbComprado)
                texto += boxes[i].value + "\n";

                // Script AJAX enviando um PUT pra a URL: /api/alimentos/alimentoComprado/${id} presente no ApiController
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
                            alert("Limite de Confirmação de um Item for vez")
                        }
                    })
      }
    }
    window.alert(texto);
  }

function adicionarAlimento (event){

    const id = $("#inputId").val();
    const nome = $("#inputNome").val();
    var quantidade = $("#inputQtd").val();
    const valor = $("#inputValorUnitario").val();
    const data = str_data;

    if(quantidade == 0){
        console.log("Foi")
        quantidade = 1

       const dados = {"id":id, "nome":nome, "quantidade":quantidade, "valorUnitario":valor, "data":data}
       const dadosItensComprados = {"id":id, "nomeItemComprado":nome, "quantidadeItemComprado":quantidade, "valorUnitarioItemComprado":valor, "dataItemComprado":data}

           console.log(dados);

           const apiUrl = `/api/alimentos/add`;
           const apiUrlComprado = `/api/alimentos/comprados/add`;

           $.ajax({
               contentType: "application/json; charset=uft-8",
               url: apiUrl,
               type: "POST",
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

           $.ajax({
              contentType: "application/json; charset=uft-8",
              url: apiUrlComprado,
              type: "POST",
              dataType: "json",
              data: JSON.stringify(dadosItensComprados),
              contentType: "application/json",
              success: function(resp) {
                  console.log(resp);
                  window.location.reload();
              },
              error: function(error) {
                  console.log(error);
              }
          })

    } else{

        console.log("Não é")
        const dados = {"id":id, "nome":nome, "quantidade":quantidade, "valorUnitario":valor, "data":data}
        const dadosItensComprados = {"id":id, "nomeItemComprado":nome, "quantidadeItemComprado":quantidade, "valorUnitarioItemComprado":valor, "dataItemComprado":data}

            console.log(dados);

            const apiUrl = `/api/alimentos/add`;
            const apiUrlComprado = `/api/alimentos/comprados/add`;

            $.ajax({
                contentType: "application/json; charset=uft-8",
                url: apiUrl,
                type: "POST",
                dataType: "json",
                data: JSON.stringify(dados),
                contentType: "application/json",
                success: function(resp) {
                    console.log(resp);
                    window.location.reload();
                },
                error: function(error) {
                    console.log(error);
                    alert('Só é possível usar o  .  para adicionar valor, ex: 5.50')
                }
            })

            $.ajax({
              contentType: "application/json; charset=uft-8",
              url: apiUrlComprado,
              type: "POST",
              dataType: "json",
              data: JSON.stringify(dadosItensComprados),
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
 }


 function updateAlimento (event){

    const id = $("#idEdit").val();
    const nome = $("#nomeEdit").val();
    const categoria = $("#categoriaEdit").val();
    const quantidade = $("#quantidadeEdit").val();
    const valor = $("#valorUnitarioEdit").val();
    const data = $("#dataEdit").val();

    const dados = {"id":id, "nome":nome, "categoria":categoria, "quantidade":quantidade, "valorUnitario":valor, "data":data}

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

 function deleteAlimento(){

//      const id = $("#idEdit").val();
//      const nome = $("#nomeEdit").val();
//      const quantidade = $("#quantidadeEdit").val();
//      const data = $("#dataEdit").val();

      const dados = {"id":id}

      console.log(dados);


      const apiUrl = `/api/alimentos/deletarAlimento/${id}`;

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


//function updateAlimentoComprado (event){
//
//    const id = $("#idEdit").val();
//    const comprado = $("#compradoEdit").val();
//
//    const dados = {"id":id, "comprado":comprado}
//
//    console.log(dados);
//
//
//    const apiUrl = `/api/alimentos/alimentoComprado/${id}`;
//
//    $.ajax({
//        contentType: "application/json; charset=uft-8",
//        url: apiUrl,
//        type: "PUT",
//        dataType: "json",
//        data: JSON.stringify(dados),
//        contentType: "application/json",
//        success: function(resp) {
//            console.log(resp);
//            window.location.reload();
//        },
//        error: function(error) {
//            console.log(error);
//        }
//    })
// }

// function confirmarLista (event){
//
//     const id = $("#inputId").val();
//     const nome = $("#inputNome").val();
//     var quantidade = $("#inputQtd").val();
//     const valor = $("#inputValorUnitario").val();
//     const data = str_data;
//
//     if(quantidade == 0){
//         console.log("Foi")
//         quantidade = 1
//
//        const dados = {"id":id, "nome":nome, "quantidade":quantidade, "valorUnitario":valor, "data":data}
//
//            console.log(dados);
//
//            const apiUrl = `/api/alimentos/add`;
//
//            $.ajax({
//                contentType: "application/json; charset=uft-8",
//                url: apiUrl,
//                type: "POST",
//                dataType: "json",
//                data: JSON.stringify(dados),
//                contentType: "application/json",
//                success: function(resp) {
//                    console.log(resp);
//                    window.location.reload();
//                },
//                error: function(error) {
//                    console.log(error);
//                }
//            })
//
//     } else{
//         console.log("Não é")
//         const dados = {"id":id, "nome":nome, "quantidade":quantidade, "valorUnitario":valor}
//
//             console.log(dados);
//
//             const apiUrl = `/api/alimentos/add`;
//
//             $.ajax({
//                 contentType: "application/json; charset=uft-8",
//                 url: apiUrl,
//                 type: "POST",
//                 dataType: "json",
//                 data: JSON.stringify(dados),
//                 contentType: "application/json",
//                 success: function(resp) {
//                     console.log(resp);
//                     window.location.reload();
//                 },
//                 error: function(error) {
//                     console.log(error);
//                 }
//             })
//     }
//
//
//
//  }



