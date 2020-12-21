/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(Document).ready(function(){
    $(".div-buttons").on("click","#insertData",function(){
        var ht = $(".div-register-form").html();
        $(".form-div").html("");
        $(".form-div").append(ht);
        $("#submit").attr("value","Register");
    });
    $(".div-buttons").on("click","#deleteData",function(){
        var ht = $(".div-delete-form").html();
        $(".form-div").html("");
        $(".form-div").html(ht);
    });
    
    $(".div-buttons").on("click","#updateData",function(){
        var ht = $(".div-register-form").html();
        $(".form-div").html("");
        $(".form-div").append(ht);
        $("#submit").attr("value","Update");
    });
    
    $(".div-buttons").on("click", "#showData", function() { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
        $(".form-div").html("");
        $.ajax({
            type: "POST",
            url: "ShowDataServlet",
            dataType: "text",
            // for asynk task
            /*beforeSend: function(){
                $(".loader").css("display","block");
                alert();
            },
            complete: function(){
                $(".loader").hide();
            },*/
            success: function(htm) {
                //$(".loader").css("display","none");
                $(".form-div").html(htm);
            }
        });
    });
});


