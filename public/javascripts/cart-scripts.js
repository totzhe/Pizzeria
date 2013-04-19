/**
 * Created with IntelliJ IDEA.
 * User: Artyom
 * Date: 20.04.13
 * Time: 2:41
 * To change this template use File | Settings | File Templates.
 */


$(document).ready(function () {
    $("body").on('change', 'input#stepper', function () {
        var id = $(this).attr("dish_id");
        var q = $(this).val();
        var elem = $(this);
        jsRoutes.controllers.OrderController.editItem(id, q).ajax({
            type: "PUT",
            data: null,
            dataType: 'json',   //тип ответа
            success: function (data) {
                $("#item_cost"+id).html(data.item_cost + " руб.");
                $("#sum").html("Сумма: " + data.sum + " руб.");
            },
            error: function () {
                alert("Edit error!");
            }
        });
    });
});

$(document).ready(function () {
    $("body").on('click', '.btn-alert', function () {
        var id = $(this).attr("dish_id");
        jsRoutes.controllers.OrderController.removeItem(id).ajax({
            type: "DELETE",
            data: null,
            dataType: 'text',   //тип ответа
            success: function (data) {
                $("#"+id).remove();
                $("#sum").html("Сумма: " + data + " руб.");
            },
            error: function () {
                alert("Remove error!");
            }
        });
    });
});