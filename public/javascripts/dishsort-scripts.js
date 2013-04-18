/**
 * Created with IntelliJ IDEA.
 * User: Artyom
 * Date: 17.04.13
 * Time: 15:55
 * To change this template use File | Settings | File Templates.
 */

$(document).ready(function () {
    $('.carousel').carousel()
})

/*< !--Пример
 удаления
 элементов
 < script
 type = "text/javascript" >
 //jQuery("#items a").click(
 jQuery("#index_t .span4").click( //реагирует на щелчок по атрибуту "a" элемента с id=#index_t
 function () {
 $(this).remove()
 //$(this).replaceWith("1");
 return false;
 }
 )
 < /script> -->*/

//<!--Пример подгрузки страницы-->
$("#menu").click(function () {
        $.get("/menu", function (data) //передается функция-обработчик результата get
        {         //ее описание
            $("body").html(data);
        });
        return false;
    }
)


$(document).ready(function () {
    $("#JsonBOTH").click(function () {
        var jsonToSend = {};
        jsonToSend.name = "HELLOWORLD";
        var outputData = JSON.stringify(jsonToSend);
        jsRoutes.controllers.Application.JsonExample().ajax({
            type: "POST",
            data: outputData,
            dataType: 'text',   //тип ответа
            contentType: 'application/json',
            success: function (data) {
                alert(data);
            },
            error: function () {
                alert("Error!");
            }
        });
    });
});

$(document).ready(function () {
    $("#JsonGET").click(function () {
        jsRoutes.controllers.Application.JsonExampleGET().ajax({
            type: "GET",
            data: null,
            dataType: 'json',   //тип ответа
            success: function (data) {
                alert(data);
                //data = $.parseJSON(data);
                //alert(data);
                $.each(data, function () {
                    alert(this.id + " " + this.name + " " + this.picturePath);
                    /*$.each(this, function(key, value) {
                     alert(this);
                     }); */
                });
            },
            error: function () {
                alert("Error!");
            }
        });
    });
});

$(document).ready(function () {
    $("#JsonPOST").click(function () {
        var jsonToSend = {};
        jsonToSend.name = "HELLOWORLD";
        var outputData = JSON.stringify(jsonToSend);
        jsRoutes.controllers.Application.JsonExamplePOST().ajax({
            type: "POST",
            data: outputData,
            dataType: 'text',   //тип ответа
            contentType: 'application/json',
            success: function (data) {
                alert("hi" + data);
            },
            error: function () {
                alert("Error!");
            }
        });
    });
});/*

$(document).ready(function () {
    //$("ul").html("");
    $("body").html("HELLO");
});*/
