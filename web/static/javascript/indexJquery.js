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
});


