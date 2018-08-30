<div id="header" class="navbar-toggleable-md  shadow-after-3 clearfix position-fixed">
    <!-- TOP BAR-->
    <div id="topBar" class="dark sticky">
        <div class="container">

            <!-- right -->
        <ul class="top-links list-inline float-right has-topBar">

                    <#if logged >
                        <li>
                            <a class="dropdown-toggle no-text-underline" data-toggle="dropdown" href="#"><i
                                    class="fa fa-user hidden-xs-down"></i> IL MIO ACCOUNT </a>
                            <ul class="dropdown-menu float-right has-topBar">
                                <li><a tabindex="-1" href="#"><i class="fa fa-history"></i> I MIEI
                                    TIROCINI</a></li>
                                <li class="divider"></li>
                                <li><a tabindex="-1" href="/account"><i class="fa fa-cog"></i> IMPOSTAZIONI
                                    DELL'ACCOUNT </a></li>
                                <li class="divider"></li>
                                <li><a tabindex="-1" href="/logout"><i class="glyphicon glyphicon-off"></i> logout
                                </a></li>
                            </ul>


                        </li>
                    </ul>
                     <!-- left -->
            <ul class="top-links list-inline has-topBar">
                <li class="text-welcome hidden-xs-down p-10">Benvenuto, ${Nome}</li>

            </ul>
                    <#else>
                    <li class="hidden-xs-down" style="border-left: rgba(255,255,255,0.1) 1px solid;"><a href="/login">LOGIN</a></li>

                    <li class="hidden-xs-down"><a href="/registration">REGISTRAZIONE</a></li>
                    </ul>
                    </#if>

            <!-- left -->
            <ul class="top-links list-inline has-topBar">
                <li class="text-welcome hidden-xs-down p-10">Benvenuto su Internship Tutor</li>

            </ul>


        </div>
    </div>
    <!-- /TOP BAR-->


    <header id="topNav">
        <div class="container">
            <!-- Mobile Menu Button -->
            <button class="btn btn-mobile" data-toggle="collapse" data-target=".nav-main-collapse">
                <i class="fa fa-bars"></i>
            </button>


            <!-- Logo -->
            <a class="logo float-left mb-5 mr-10scripts.jsscripts.js" href="/home">
                <img src="/imgs/interns.jpg" alt=""/>
            </a>

            <div class="navbar-collapse collapse nav-main-collapse submenu-dark">
                <nav class="nav-main">
                    <ul id="topMain" class="nav nav-pills nav-main">
                        <li class="dropdown active">
                            <a class="dropdown-toggle noicon" href="/home">
                                HOME
                            </a>
                        </li>
                        <li class="dropdown active">
                            <a class="dropdown-toggle noicon" href="/listaofferte">
                                LISTA OFFERTE TUTORAGGI
                            </a>
                        </li>
                        <li class="dropdown active">
                            <a class="dropdown-toggle noicon" href="/listaconvenzioni">
                                LISTA CONVENZIONI
                            </a>
                        </li>
                        <li class="dropdown active">
                            <a class="dropdown-toggle noicon" href="informazioni.html">
                                INFORMAZIONI
                            </a>
                        </li>
                        <form class="d-inline-block col-lg-12 col-xl-4 mb-lg-2">
                            <div class="input-group">
                                <input type="text" class="form-control" aria-label=""
                                       placeholder="Cerca nell'intero del sito">
                                <span class="input-group-btn">
                                            <button class="btn btn-primary material-ico" type="submit">
                                                <i class="material-icons">search</i>
                                            </button>
                                        </span>
                            </div>
                        </form>
                    </ul>
                </nav>
            </div>
        </div>
    </header>
</div>
