(function ($) {
    "use strict";
    
    // Dropdown on mouse hover
    $(document).ready(function () {
        function toggleNavbarMethod() {
            if ($(window).width() > 992) {
                $('.navbar .dropdown').on('mouseover', function () {
                    $('.dropdown-toggle', this).trigger('click');
                }).on('mouseout', function () {
                    $('.dropdown-toggle', this).trigger('click').blur();
                });
            } else {
                $('.navbar .dropdown').off('mouseover').off('mouseout');
            }
        }
        toggleNavbarMethod();
        $(window).resize(toggleNavbarMethod);
    });
    
    
    // Back to top button
    $(window).scroll(function () {
        if ($(this).scrollTop() > 100) {
            $('.back-to-top').fadeIn('slow');
        } else {
            $('.back-to-top').fadeOut('slow');
        }
    });
    $('.back-to-top').click(function () {
        $('html, body').animate({scrollTop: 0}, 1500, 'easeInOutExpo');
        return false;
    });


    // Vendor carousel
    $('.vendor-carousel').owlCarousel({
        loop: true,
        margin: 29,
        nav: false,
        autoplay: true,
        smartSpeed: 1000,
        responsive: {
            0:{
                items:2
            },
            576:{
                items:3
            },
            768:{
                items:4
            },
            992:{
                items:5
            },
            1200:{
                items:6
            }
        }
    });


    // Related carousel
    $('.related-carousel').owlCarousel({
        loop: true,
        margin: 29,
        nav: false,
        autoplay: true,
        smartSpeed: 1000,
        responsive: {
            0:{
                items:1
            },
            576:{
                items:2
            },
            768:{
                items:3
            },
            992:{
                items:4
            }
        }
    });


    // Product Quantity
    $('.quantity button').on('click', function () {
        var button = $(this);
        var oldValue = button.parent().parent().find('input').val();
        if (button.hasClass('btn-plus')) {
            var newVal = parseFloat(oldValue) + 1;
        } else {
            if (oldValue > 0) {
                var newVal = parseFloat(oldValue) - 1;
            } else {
                newVal = 0;
            }
        }
        button.parent().parent().find('input').val(newVal);
    });
    
})(jQuery);


//First request to server to create order
const paymentStart=()=>{
    console.log("Payment Started...");
    let amount=$("#TotalAmt").val();
    console.log(amount);
    if(amount == '' || amount == null || amount == '0.0'){
        // alert("Amount Is Required !!")
        swal("Failed", "Amount Is Required","error");
        return;
    }


    //Code...
    //We will use Ajax to send request to server to create order- Jquery
    $.ajax(
        {
            url:'/create_order',
            data:JSON.stringify({amount:amount,info:'order_request'}),
            contentType:'application/json',
            type:'POST',
            dataType:'json',
            success:function(response){
                //invoked when success
                console.log(response);
                if(response.status == 'created'){
                    //open payment form
                    let options={
                        key:'rzp_test_lgnhBaGi7UvJEA',
                        amount:response.amount,
                        currency:'INR',
                        name:'TechHub',
                        description:'Your Ultimate Guide For Laptop and Accessories Marketplace',
                        image:'https://img.freepik.com/free-photo/medium-shot-man-wearing-vr-glasses_23-2149126949.jpg?w=1380&t=st=1713881935~exp=1713882535~hmac=dcecff61c0bf179f5e3ae4fb1cbcc692ee2f39e983258ce65777c9a3f2d2de56',
                        order_id:response.id,
                        handler:function(response){
                            console.log(response.razorpay_payment_id);
                            console.log(response.razorpay_order_id);
                            console.log(response.razorpay_signature);
                            console.log('Payment Successful');

                            updatePaymentOnServer(response.razorpay_payment_id,response.razorpay_order_id,"paid")

                            // alert("Congratulations Payment Successful !!");
                        },

                        prefill:{
                            name:"Demo Customer",
                            email:"demo@gmail.com",
                            contact:"9987098890",
                        },

                        // notes:{
                        //     "":"Thanks for using RazoryPay"
                        // },

                        theme:{
                            color:"#D3D3D3"
                        },
                    };

                    let rzp = new Razorpay(options);

                    rzp.on('payment.failed', function(response){
                        console.log(response.error.code);
                        console.log(response.error.description);
                        console.log(response.error.source);
                        console.log(response.error.step);
                        console.log(response.error.reason);
                        console.log(response.error.metadata.order_id);
                        console.log(response.error.metadata.payment_id);
                        // alert("Oops Payment Failed !");
                        swal("Failed", "Oops Payment Failed","error");
                    });
                    rzp.open();
                    
                }
            },
            error:function(response){
                //invoked when error
                console.log(error);
                alert("Something Went Wrong !")
            },
        }
    );

};

function updatePaymentOnServer(payment_id,order_id,status){
    $.ajax({
        url:'/update_order',
            data:JSON.stringify({payment_id:payment_id,order_id:order_id,status:status}),
            contentType:'application/json',
            type:'POST',
            dataType:'json',
            success:function(response){
                swal("Good job!", "Payment Successful", "success");
            },
            error:function(error){
                swal("Failed", "Your Payment is successful, but we did not get on server, we will contact you as soon as possible",
                "error");
            },
    });
}