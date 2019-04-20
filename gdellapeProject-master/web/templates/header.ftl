<div id="header" class="navbar-toggleable-md  shadow-after-3 clearfix position-fixed <#if notview?? ><#if notview>d-print-none</#if></#if>">
    <!-- TOP BAR-->
    <div id="topBar" class="dark sticky">
        <div class="container">

            <!-- right -->
        <ul class="top-links list-inline float-right has-topBar">


                    <#if logged>
                        <#if accountLogged??>
                        <li>
                            <a class="dropdown-toggle no-text-underline"  <#if accountLogged=="Azienda" || accountLogged=="Tirocininate" >href="/account"<#else>href="/admin/dashboard"</#if> ><i
                                    class="fa fa-user hidden-xs-down"></i><#if accountLogged=="Azienda" || accountLogged=="Tirocininate" > IL MIO ACCOUNT<#else> DASHBOARD AMMINISTRAZIONE</#if> </a>

                            <#if accountLogged=="Azienda" || accountLogged=="Tirocininate" >
                            <ul class="dropdown-menu float-right has-topBar">
                                <a tabindex="-1"<#if accountLogged=="Azienda">href="/account/gestione-offerte"<#elseif accountLogged=="Tirocininate">href="/account"</#if>><i class="fa fa-history"></i> I MIEI TIROCINI</a></li>
                                <li class="divider"></li>
                                <li><a tabindex="-1" href="/account/impostazioni"><i class="fa fa-cog"></i> IMPOSTAZIONI
                                    DELL'ACCOUNT </a></li>
                                <li class="divider"></li>
                                <li><a tabindex="-1" href="/logout"><i class="glyphicon glyphicon-off"></i> logout
                                </a></li>
                            </ul>
                                </#if>
                            </#if>
                        </li>
                    </ul>
                     <!-- left -->
            <#if accountLogged=="Azienda" || accountLogged=="Tirocininate" >
            <ul class="top-links list-inline has-topBar">
                <li class="text-welcome hidden-xs-down p-10">Benvenuto, ${Nome}</li>

            </ul>
            </#if>
                    <#else>
                    <li class="hidden-xs-down" style="border-left: rgba(255,255,255,0.1) 1px solid;"><a href="/login">LOGIN</a></li>

                    <li class="hidden-xs-down"><a href="/registrazione">REGISTRAZIONE</a></li>
                    </ul>

                     <!-- left -->
            <ul class="top-links list-inline has-topBar">
                <li class="text-welcome hidden-xs-down p-10">Benvenuto su Internship Tutor</li>

            </ul>
                    </#if>




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
                        <li class="dropdown active ml-100">
                            <a class="dropdown-toggle noicon" href="/home">
                                HOME
                            </a>
                        </li>
                        <li class="dropdown active ml-30">
                            <a class="dropdown-toggle noicon" href="/listaofferte">
                                LISTA OFFERTE TUTORAGGI
                            </a>
                        </li>
                        <li class="dropdown active ml-30">
                            <a class="dropdown-toggle noicon" href="/listaconvenzioni">
                                LISTA CONVENZIONI
                            </a>
                        </li>
                        <li class="dropdown active ml-30">
                            <a class="dropdown-toggle noicon" href="informazioni.html">
                                INFORMAZIONI
                            </a>
                        </li>
<#--                        <form class="d-inline-block col-lg-12 col-xl-4 mb-lg-2">-->
<#--                            <div class="input-group">-->
<#--                                <input type="text" class="form-control" aria-label=""-->
<#--                                       placeholder="Cerca nell'intero del sito">-->
<#--                                <span class="input-group-btn">-->
<#--                                            <button class="btn btn-primary material-ico" type="submit">-->
<#--                                                <i class="material-icons">search</i>-->
<#--                                            </button>-->
<#--                                        </span>-->
<#--                            </div>-->
<#--                        </form>-->
                    </ul>
                </nav>
            </div>
        </div>
    </header>
</div>
