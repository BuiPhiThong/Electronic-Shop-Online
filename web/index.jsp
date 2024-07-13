
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- site metas -->
        <title>Home Page</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- bootstrap css -->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <!-- style css -->
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <!-- Responsive-->
        <link rel="stylesheet" href="css/responsive.css">
        <!-- fevicon -->
        <link rel="icon" href="images/fevicon.png" type="image/gif" />
        <!-- Scrollbar Custom CSS -->
        <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
        <!-- Tweaks for older IEs-->
        <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
        <!-- owl stylesheets --> 
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
        <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <!-- header section start -->
        <div class="header_section">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="logo" href="home"><img src="images/iconbook.png"></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse flexall" id="navbarSupportedContent">

                    <ul class="navbar-nav mr-auto ">
                        <li class="nav-item active">
                            <a class="nav-link" href="home">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="library">Library</a>
                        </li>                 
                    </ul>
                    <form id="f1" action="search">
                        <input type="text" name="key" placeholder="Nhập tên, miêu tả"/><br/>
                        <input type="submit" value="Search"/>
                    </form>
                    <c:if test="${empty sessionScope.account}" >
                        <div class="search_icon"><a href="login.jsp"><img src="images/user-icon.png"><span class="padding_left_15">Login</span></a></div>
                            </c:if>

                    <c:if test="${not empty sessionScope.account}">
                        <div class="search_icon"><a href="changepassword.jsp"><img src="images/notification-icon.png"><span class="padding_left_15">Change Password</span></a></div>
                        <div class="search_icon"><a href="logout"><img src="images/eye-icon.png"><span class="padding_left_15">Logout</span></a></div>
                        <div class="search_icon"><a href="#" onclick="show()"><img src="images/eye-icon.png"><span class="padding_left_15">Profile</span></a></div>
                            
                    </c:if> 

                    


                    <div id="profile" style="display: none">
                        Username:${sessionScope.account.username}
                        <br/>
                        Name:${sessionScope.account.name}
                        <br/>
                        Amount:${sessionScope.account.amount}
                    </div>

                    <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" style="margin-left: 30px" fill="currentColor" class="bi bi-cart" viewBox="0 0 16 16">                    
                    <a href="show">
                        <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5M3.102 4l1.313 7h8.17l1.313-7zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4m7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4m-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2m7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2"/>
                    </a>
                    </svg>
                </div>
            </nav>
        </div>
        <!-- header section end -->
        <!-- banner section end -->
        <div class="banner_section layout_padding">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <div class="banner_taital">Enjoy At <br>The MoonBooks Shop</div>
                        <p class="banner_text" style="font-size: large">Flash sale up to 75% off!<br/> Start soon 8 March</p>

                    </div>
                    <div class="col-md-6">

                    </div>
                </div>
            </div>
        </div>
        <!-- banner section end -->
        <!-- arrival section start -->

        <div class="arrival_section layout_padding">
            <div class="container">
                <div class="row">

                    <div class="col-sm-6 col-lg-6">
                        <div class="image_1" style="background-image: url(${requestScope.top1.image})">
                        </div>
                    </div>
                    <div class="col-sm-6 col-lg-6">
                        <h3 class="arrival_text">${top1.name}</h3>
                        <div class="movie_main">
                            <div class="mins_text_1">$${top1.price}</div>
                            <div class="mins_text">${top1.cid.name}</div>
<!--                            <div class="mins_text"><img src="images/icon-1.png"><span class="icon_1">${top1.quantity}</span></div>-->
                        </div>
                        <br/>
                        <p class="long_text">${top1.describe}</p>
                        <br/> <br/>
                        <div class="rating_main">
                            <div class="row">
                                <div class="col-sm-6 col-lg-6">
                                    <div class="icon_2"><img src="images/icon-2.png"><span class="padding_10">4.6 Reviewed</span></div>
                                </div>
                                <div class="col-sm-6 col-lg-6">
                                    <div class="icon_2"><img src="images/icon-2.png"><span class="padding_10">Your Rating</span></div>
                                </div>
                            </div>
                        </div>
                        <div class="paly_bt"><a href="detailproduct?pid=${top1.id}">Buy Now</a></div>
                    </div>
                </div>
            </div>

        </div>

        <!-- arrival section end -->
        <!-- movies section start -->
        <div class="movies_section layout_padding">

            <div class="movies_menu">
                <ul>
                    <c:forEach items="${requestScope.data}" var="c">
                        <li><a href="products?cid=${c.id}">${c.name}</a></li>
                        </c:forEach>
                </ul>
            </div>
            <div class="movies_section_2 layout_padding">
                <h2 class="letest_text">
                    <a>Tiểu Thuyết</a>
                </h2>
                <div class="movies_main">
                    <div class="iamge_movies_main">


                        <c:forEach var="pd" items="${requestScope.pdhome}">


                            <div class="iamge_movies">
                                <div class="image_3">
                                    <img src="${pd.image}" style="width:100%">
                                    <div class="middle">
                                        <div class="playnow_bt"><a href="detailproduct?pid=${pd.id}">Buy Now</a></div>
                                    </div>
                                </div>
                                <h1 class="code_text">${pd.name}</h1>
                                <p class="there_text">Giá tiền: $${pd.price}</p>
<!--                                <p class="there_text">${pd.quantity}</p>-->
                                <div class="star_icon">
                                    <ul>
                                        <li><a href="#"><img src="images/star-icon.png"></a></li>
                                        <li><a href="#"><img src="images/star-icon.png"></a></li>
                                        <li><a href="#"><img src="images/star-icon.png"></a></li>
                                        <li><a href="#"><img src="images/star-icon.png"></a></li>
                                        <li><a href="#"><img src="images/star-icon.png"></a></li>
                                    </ul>
                                </div>
                            </div> 


                        </c:forEach>



                    </div>
                </div>
                <div class="movies_section_2 layout_padding">
                    <h2 class="letest_text">
                        <a>Truyện Ngắn</a>
                    </h2>
                    <div class="movies_main">
                        <div class="iamge_movies_main">


                            <c:forEach var="pd" items="${requestScope.pdhome1}">


                                <div class="iamge_movies">
                                    <div class="image_3">
                                        <img src="${pd.image}" class="image" style="width:100%">
                                        <div class="middle">
                                            <div class="playnow_bt" ><a href="detailproduct?pid=${pd.id}">Buy Now</a></div>
                                        </div>
                                    </div>
                                    <h1 class="code_text">${pd.name}</h1>
                                    <p class="there_text">Giá tiền: $${pd.price}</p>
<!--                                    <p class="there_text">${pd.quantity}</p>-->
                                    <div class="star_icon">
                                        <ul>
                                            <li><a href="#"><img src="images/star-icon.png"></a></li>
                                            <li><a href="#"><img src="images/star-icon.png"></a></li>
                                            <li><a href="#"><img src="images/star-icon.png"></a></li>
                                            <li><a href="#"><img src="images/star-icon.png"></a></li>
                                            <li><a href="#"><img src="images/star-icon.png"></a></li>
                                        </ul>
                                    </div>
                                </div> 


                            </c:forEach>



                        </div>
                    </div>
                    <!-- movies section end -->
                    <!-- footer  section start -->
                    <div class="footer_section layout_padding">
                        <div class="container">
                            <div class="footer_menu">
                                <ul>
                                    <li><a href="home">Home</a></li>
                                    <li><a href="library">Library</a></li>
                                </ul>
                            </div>
                            <div class="social_icon">
                                <ul>
                                    <li><a href="https://www.facebook.com/profile.php?id=100008828268367"><img src="images/fb-icon.png"></a></li>
                                    <li><a href="https://www.instagram.com/thoong0904/"><img src="images/instagram-icon.png"></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- footer  section end -->
                    <!-- copyright section start -->
                    <div class="copyright_section">
                        <div class="container">
                            <div class="copyright_text">Copyright 2019 All Right Reserved By <a href="https://html.design">Free html Templates</a></div>
                        </div>
                    </div>
                    <!-- copyright section end -->
                    <!-- Javascript files-->
                    <script src="js/jquery.min.js"></script>
                    <script src="js/popper.min.js"></script>
                    <script src="js/bootstrap.bundle.min.js"></script>
                    <script src="js/jquery-3.0.0.min.js"></script>
                    <!-- sidebar -->
                    <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
                    <script src="js/custom.js"></script>
                    <!-- javascript --> 
                    <script src="js/owl.carousel.js"></script>
                    <script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
                    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
                    <script>
                            $('#datepicker').datepicker({
                                uiLibrary: 'bootstrap4'
                            });
//                            function change() {
//                                document.getElementById("f1").submit();
//                            }

                            function show() {
                                var x = document.getElementById("profile");
                                if (x.style.display == "none") {
                                    x.style.display = "block";
                                } else {
                                    x.style.display = "none";
                                }
                            }

                            const exampleModal = document.getElementById('exampleModal');
                            if (exampleModal) {
                                exampleModal.addEventListener('show.bs.modal', event => {
                                    // Button that triggered the modal
                                    const button = event.relatedTarget;
                                    // Extract info from data-bs-* attributes
                                    const recipient = button.getAttribute('data-bs-whatever');
                                    // If necessary, you could initiate an Ajax request here
                                    // and then do the updating in a callback.

                                    // Update the modal's content.
                                    const modalTitle = exampleModal.querySelector('.modal-title');
                                    const modalBodyInput = exampleModal.querySelector('.modal-body input');

                                    modalTitle.textContent = `New message to ${recipient}`;
                                    modalBodyInput.value = recipient;
                                });
                            }
                    </script>
                    </body>
                    </html>
