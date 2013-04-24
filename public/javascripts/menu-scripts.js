/**
 * Created with IntelliJ IDEA.
 * User: Artyom
 * Date: 17.04.13
 * Time: 23:07
 * To change this template use File | Settings | File Templates.
 */


$(document).ready(function () {
    $("body").on('click', '.btn-success', function () {
        var id = $(this).val();
        var q = 1;
        var btn = $(this);
        jsRoutes.controllers.OrderController.addItem(id, q).ajax({
            type: "PUT",
            data: null,
            dataType: 'text',   //тип ответа
            success: function (data) {
                //alert(data);
                btn.removeClass("btn-success");
                btn.addClass("btn-danger");
                btn.html("Убрать из корзины");
                $("#sum").html(data + " руб.");
            },
            error: function () {
                alert("Add error!");
            }
        });
    });
});

$(document).ready(function () {
    $("body").on('click', '.btn-danger', function () {
        var id = $(this).val();
        var btn = $(this);
        //btn.attr("class", ".btn btn-success") ;
        //$("body").html("HI"+jsonToSend);
        btn.removeClass("btn-danger");
        btn.addClass("btn-success");
        btn.html("Заказать");
        jsRoutes.controllers.OrderController.removeItem(id).ajax({
            type: "DELETE",
            data: null,
            dataType: 'text',   //тип ответа
            success: function (data) {
                //alert(data);
                btn.removeClass("btn btn-danger");
                btn.addClass("btn btn-success");
                btn.html("Заказать");
                $("#sum").html(data + " руб.");
            },
            error: function () {
                alert("Remove error!");
            }
        });
    });
});