<!-- /FOOTER-->
    <footer id="footer" <#if notview?? ><#if notview>class="d-print-none"</#if></#if>>
        <div class="container">

            <div class="row">

                <div class="col-md-3">
                    <div class="row">
                        <div class="col-4">
                            <!-- Footer Logo -->
                            <img class="footer-logo" src="http://www.disim.univaq.it/didattica/img/logo_univaq.png"
                                 alt=""/>
                        </div>
                        <div class="col-6 text-left py-5p">

                            <!-- Short Description -->
                            <a href="http://univaq.it">Universit&agrave; degli Studi dell&apos;Aquila</a>
                        </div>
                    </div>
                    <!-- Contact Address -->
                    <address>
                        <ul class="list-unstyled">
                            <li class="footer-sprite address">
                                67100 L&apos;Aquila, Coppito, Via Vetoio<br>
                            </li>
                            <li class="footer-sprite phone">
                                Phone: +39 0862 433002
                            </li>
                            <li class="footer-sprite phone">
                                Phone: +39 0862 433180 (fax)
                            </li>
                            <li class="footer-sprite email">
                                <a href="mailto:disim.sad@univaq.it">disim.sad@univaq.it</a>
                            </li>
                        </ul>
                    </address>
                    <!-- /Contact Address -->

                </div>


                <div class="col-md-7">

                    <!-- Newsletter Form -->
                    <h4 class="letter-spacing-1">INTERNSHIP TUTOR</h4>
                    <p>Internship Tutor rappresenta un sistema web per la gestione dell&apos;iter completo dei tirocini
                        universitari del degli Studi dell&apos;Aquila.</p>
                </div>




                <div class="col-md-2">

                    <!-- Links -->
                    <h4 class="letter-spacing-1">LINK UTILI</h4>
                    <ul class="footer-links list-unstyled">
                        <li><a href="/home">Home</a></li>
                        <li><a href="/listaofferte">Lista Offerte Tuttoraggi</a></li>
                        <li><a href="/listaconvenzioni">Lista Convenzioni</a></li>
                        <#if logged>
                        <#if accountLogged??>
                            <#if accountLogged=="Azienda" || accountLogged=="Tirocininate" >
                                <li><a href="/account">Il Mio Accout</a></li>
                                <#if accountLogged=="Azienda">
                                    <li><a href="/account/gestione-offerte">I Miei Tirocini</a></li>
                                    <#elseif accountLogged=="Tirocininate">
                                        <li><a href="/account/moduli">I Miei Tirocini</a></li>
                                </#if>
                            </#if>
                        </#if>
                        </#if>
                    </ul>
                    <!-- /Links -->

                </div>


            </div>

        </div>

        <div class="copyright">
            <div class="container">
                <ul class="float-right m-0 list-inline mobile-block">
                    <li><a href="#">Terms & Conditions</a></li>
                    <li>&bull;</li>
                    <li><a href="#">Privacy</a></li>
                </ul>
                &copy; All Rights Reserved, INTERNSHIP TUTOR
            </div>
        </div>
    </footer>
    <!-- /FOOTER -->