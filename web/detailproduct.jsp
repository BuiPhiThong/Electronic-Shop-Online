
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Detai Product</title>
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
                <a class="logo" href="index.html"><img src="images/iconbook.png"></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
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
        <section class="py-5">
            <div class="container">
                <div class="row gx-5">
                    <aside class="col-lg-6">
                        <div class="border rounded-4 mb-3 d-flex justify-content-center">
                            <a data-fslightbox="mygalley" class="rounded-4" target="_blank" data-type="image" href="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/detail1/big.webp">
                                <img style="max-width: 100%; max-height: 100vh; margin: auto;" class="rounded-4 fit" src="${detailproduct.image}" />
                            </a>
                        </div>
                        <!-- thumbs-wrap.// -->
                        <!-- gallery-wrap .end// -->
                    </aside>
                    <main class="col-lg-6">
                        <c:set value="${detailproduct.id}" var="id"/>
                        <form name="f" action="" method="post">
                            <div class="ps-lg-3">
                                <h1 class="title text-dark">
                                    ${detailproduct.name}
                                </h1>
                                <div class="d-flex flex-row my-3">
                                    <div class="text-warning mb-1 me-2">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fas fa-star-half-alt"></i>
                                        <span class="ms-1">
                                            4.5
                                        </span>
                                    </div>

                                </div>

                                <div class="mb-3">
                                    <span class="h5">$${detailproduct.price}</span>
                                    <span class="text-muted">/Book</span>
                                </div>

                                <p>
                                    ${detailproduct.describe}
                                </p>

                                <div class="row">
                                    <dt class="col-3">Type</dt>
                                    <dd class="col-9">${detailproduct.cid.name}</dd>

                                    <dt class="col-3">Author</dt>
                                    <dd class="col-9">${detailproduct.auid.name}</dd>

                                    <dt class="col-3">Publisher</dt>
                                    <dd class="col-9">${detailproduct.pid.name}</dd>

                                    <dt class="col-3">Brand</dt>
                                    <dd class="col-9">${detailproduct.pid.address}</dd>
                                </div>

                                <hr />
                                <label>Số lượng đặt mua</label>
                                <input style="text-align: center" type="number" name="num" value="1">
                                <div class="row mb-4">

                                    <!-- col.// -->
                                    <div class="col-md-4 col-6 mb-3">
                                        <label class="mb-2 d-block">Số lượng còn trong kho</label>
                                        <div class="input-group mb-3" style="width: 170px;">
                                            <button class="btn btn-white border border-secondary px-3" type="button" id="button-addon1" data-mdb-ripple-color="dark">
                                                ${detailproduct.quantity}
                                            </button>

                                            <% 
                                                    String error = request.getParameter("error");
                                                    if (error != null && error.equals("quantity_exceeded")) {
                                            %>
                                            <h4 style="color: red">Số lượng mua vượt quá kho</h4>
                                            <% } %>


                                        </div>
                                    </div>
                                </div>
                                <a onclick="buy('${id}')" class="btn btn-primary shadow-0"> <i class="me-1 fa fa-shopping-basket"></i>Add to cart</a>
                            </div>
                        </form>                 
                    </main>
                </div>
            </div>
        </section>
        <!-- content -->

        <section class="bg-light border-top py-4">
            <div class="container">
                <div class="row gx-4">
                    <div class="col-lg-8 mb-4">
                        <div class="border rounded-2 px-3 py-2 bg-white">
                            <!-- Pills navs -->
                            <ul class="nav nav-pills nav-justified mb-3" id="ex1" role="tablist">
                                <li class="nav-item d-flex" role="presentation">
                                    <a class="nav-link d-flex align-items-center justify-content-center w-100 active" id="ex1-tab-1" data-mdb-toggle="pill" href="#ex1-pills-1" role="tab" aria-controls="ex1-pills-1" aria-selected="true">Thông tin sản phẩm</a>
                                </li>

                            </ul>
                            <!-- Pills navs -->

                            <!-- Pills content -->
                            <div class="tab-content" id="ex1-content">
                                <div class="tab-pane fade show active" id="ex1-pills-1" role="tabpanel" aria-labelledby="ex1-tab-1">
                                    <p>
                                        ${detailproduct.describe}
                                    </p>
                                    <div class="row mb-2">
                                        <div class="col-12 col-md-6">
                                            <ul class="list-unstyled mb-0">
                                                <li><i class="fas fa-check text-success me-2"></i>Some great feature name here</li>
                                                <li><i class="fas fa-check text-success me-2"></i>Lorem ipsum dolor sit amet, consectetur</li>
                                                <li><i class="fas fa-check text-success me-2"></i>Duis aute irure dolor in reprehenderit</li>
                                                <li><i class="fas fa-check text-success me-2"></i>Optical heart sensor</li>
                                            </ul>
                                        </div>
                                        <div class="col-12 col-md-6 mb-0">
                                            <ul class="list-unstyled">
                                                <li><i class="fas fa-check text-success me-2"></i>Easy fast and ver good</li>
                                                <li><i class="fas fa-check text-success me-2"></i>Some great feature name here</li>
                                                <li><i class="fas fa-check text-success me-2"></i>Modern style and design</li>
                                            </ul>
                                        </div>
                                    </div>
                                    <table class="table border mt-3 mb-2">
                                        <tr>
                                            <th class="py-2">Nhà Xuất Bản</th>
                                            <td class="py-2">${detailproduct.pid.name}</td>
                                        </tr>
                                        <tr>
                                            <th class="py-2">Tác Giả</th>
                                            <td class="py-2">${detailproduct.auid.name}</td>
                                        </tr>
                                        <tr>
                                            <th class="py-2">Năm XB</th>
                                            <td class="py-2">${detailproduct.dom}</td>
                                        </tr>
                                        <tr>
                                            <th class="py-2">From</th>
                                            <td class="py-2">${detailproduct.pid.address}</td>
                                        </tr>
                                        <tr>
                                            <th class="py-2">Số Trang</th>
                                            <td class="py-2">${detailproduct.quantity}</td>
                                        </tr>
                                    </table>
                                </div>
                                <div class="tab-pane fade mb-2" id="ex1-pills-2" role="tabpanel" aria-labelledby="ex1-tab-2">
                                    Tab content or sample information now <br />
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
                                    aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui
                                    officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis
                                    nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                                </div>
                                <div class="tab-pane fade mb-2" id="ex1-pills-3" role="tabpanel" aria-labelledby="ex1-tab-3">
                                    Another tab content or sample information now <br />
                                    Dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea
                                    commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt
                                    mollit anim id est laborum.
                                </div>
                                <div class="tab-pane fade mb-2" id="ex1-pills-4" role="tabpanel" aria-labelledby="ex1-tab-4">
                                    Some other tab content or sample information now <br />
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
                                    aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui
                                    officia deserunt mollit anim id est laborum.
                                </div>
                            </div>
                            <!-- Pills content -->
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="px-0 border rounded-2 shadow-0">
                            <div class="card">
                                <div class="card-body">

                                    <h5 class="card-title">Similar items</h5>
                                    <c:forEach var="s" items="${requestScope.similarproduct}">
                                        <div class="d-flex mb-3">
                                            <a href="detailproduct?pid=${s.id}" class="me-3">
                                                <img src="${s.image}" style="min-width: 96px; height: 96px;" class="img-md img-thumbnail" />
                                            </a>
                                            <div class="info">
                                                <a href="detailproduct?pid=${s.id}" class="nav-link mb-1">
                                                    ${s.name}
                                                </a>
                                                <strong class="text-dark"> $${s.price}</strong>
                                            </div>
                                        </div>
                                    </c:forEach>


                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
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
        <script type="text/javascript">
                                    $('#datepicker').datepicker({
                                        uiLibrary: 'bootstrap4'
                                    });
                                    function buy(id) {
                                        var m = document.f.num.value;// lay duoc so luong dat mua 
                                        document.f.action = "buy?id=" + id + "&num=" + m;
                                        document.f.submit();
                                    }
                                    function show() {
                                        var x = document.getElementById("profile");
                                        if (x.style.display == "none") {
                                            x.style.display = "block";
                                        } else {
                                            x.style.display = "none";
                                        }
                                    }
        </script>
    </body>
</html>    