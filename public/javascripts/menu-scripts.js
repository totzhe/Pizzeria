/**
 * Created with IntelliJ IDEA.
 * User: Artyom
 * Date: 17.04.13
 * Time: 23:07
 * To change this template use File | Settings | File Templates.
 */


$(document).ready(function () {
    $(".btn.btn-success").click(function () {
        var id = $(this).attr("value");
        var q = 1;
        var btn = $(this);
        jsRoutes.controllers.OrderController.addItem(id, q).ajax({
            type: "PUT",
            data: null,
            dataType: 'text',   //тип ответа
            success: function (data) {
                //alert(data);
                btn.attr("class", ".btn btn-danger") ;
                btn.html("Убрать из корзины") ;
                $("#sum").html("Сумма: " + data + " руб.");
            },
            error: function () {
                alert("Error!");
            }
        });
    });
});

$(document).ready(function () {
    $(".btn.btn-danger").click(function () {
        alert("Hello world1!");
        var id = $(this).attr("value");
        var btn = $(this);
        btn.attr("class", ".btn btn-success") ;
        //$("body").html("HI"+jsonToSend);
        jsRoutes.controllers.OrderController.removeItem(id, q).ajax({
            type: "DELETE",
            data: null,
            dataType: 'text',   //тип ответа
            success: function (data) {
                //alert(data);
                btn.attr("class", ".btn btn-success") ;
                btn.html("Заказать") ;
                $("#sum").html("Сумма:!!! " + data + " руб.");
            },
            error: function () {
                alert("Error!");
            }
        });
    });
});