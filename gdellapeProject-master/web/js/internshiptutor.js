jQuery(window).ready(function () {

    if(jQuery('#contenuto-lista-tutoraggi').length > 0){
        $("#querystring ,#querystring-sm").css("display", "none");
        console.log("display none");
        $("#filtra, #filtra-sm").click(function () {
            console.log("click");
            if ($(this).hasClass("fa-plus-circle")) {
                $("#filtra.fa-plus-circle,#filtra-sm.fa-plus-circle ").removeClass("fa-plus-circle").addClass("fa-minus-circle");
                $("#querystring,#querystring-sm").fadeIn("slow");
            }
            else {
                $("#filtra.fa-minus-circle,#filtra-sm.fa-minus-circle").removeClass("fa-minus-circle").addClass("fa-plus-circle");
                $("#querystring, #querystring-sm").fadeOut("slow");
            }
        });

    }


    if(jQuery('#form_registrazione').length > 0) {

        $("#Tipologia").change(function () {
            var tipo = $("#Tipologia").val();
            if (tipo == "Tirocinante") {
                $("#Ente-Azienda").fadeOut();
                $(" fieldset[name='Ente-Azienda']").animate({
                    opacity: 0,
                    height: "hide"
                }, 1000);
                if ($("#Tirocinante").length > 0) {
                } else {
                    $("fieldset[name='Accesso']").after("<div id=\"Tirocinante\" class=\"header-form mb-30\" style=\"display:none;\"><i class=\"fa fa-user\"></i>&nbsp; INFORMAZIONI\n" +
                        "            PERSONALI TIROCINANTE\n" +
                        "        </div>\n" +
                        "        <fieldset name=\"Tirocinante\" style=\"display:none;\">\n" +
                        "            <div class=\"row pr-15 mb-35\">\n" +
                        "                <div class=\"col-md-auto mt-6 pr-0\">\n" +
                        "                    <h4>Nominativo del tirocinante: </h4>\n" +
                        "                </div>\n" +
                        "                <div class=\"col\">\n" +
                        "                    <label class=\"input\">\n" +
                        "                        <input type=\"text\" placeholder=\"Nome\" name=\"Nome\" >\n" +
                        "                    </label>\n" +
                        "                </div>\n" +
                        "                <div class=\"col col\">\n" +
                        "                    <label class=\"input\">\n" +
                        "                        <input type=\"text\" placeholder=\"Cognome\" name=\"Cognome\" >\n" +
                        "                    </label>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "\n" +
                        "            <div class=\"row pr-15 mb-35\">\n" +
                        "                <div class=\"col-md-auto mt-6\">\n" +
                        "                    <h4>Nato a:</h4>\n" +
                        "                </div>\n" +
                        "\n" +
                        "                <div class=\"col\">\n" +
                        "                    <label class=\"input\">\n" +
                        "                        <i class=\"ico-append fa fa-map-o\"></i>\n" +
                        "                        <input type=\"text\" placeholder=\"Luogo di Nascita\" name=\"LuogoNascita\" >\n" +
                        "                    </label>\n" +
                        "                </div>\n" +
                        "\n" +
                        "                <div class=\"col-md-auto mt-6\">\n" +
                        "                    <h4>Provincia: </h4>\n" +
                        "                </div>\n" +
                        "\n" +
                        "                <div class=\"col-md-1\">\n" +
                        "                    <label class=\"input\">\n" +
                        "                        <input type=\"text\" class=\"masked\" data-format=\"aa\" placeholder=\"XX\" name=\"ProvinciaNascita\"\n" +
                        "                               >\n" +
                        "                    </label>\n" +
                        "                </div>\n" +
                        "\n" +
                        "\n" +
                        "                <div class=\"col-md-auto mt-6\">\n" +
                        "                    <h4>Il: </h4>\n" +
                        "                </div>\n" +
                        "\n" +
                        "                <div class=\"col col-md-3\">\n" +
                        "                    <label class=\"input\">\n" +
                        "                        <i class=\"ico-append fa fa-calendar\"></i>\n" +
                        "                        <input type=\"date\"  name=\"DataNascita\" >\n" +
                        "                    </label>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "\n" +
                        "            <div class=\"row pr-15 mb-35\">\n" +
                        "                <div class=\"col-md-auto mt-6 pr-0\">\n" +
                        "                    <h4>Residente in: </h4>\n" +
                        "                </div>\n" +
                        "\n" +
                        "                <div class=\"col\">\n" +
                        "                    <label class=\"input\">\n" +
                        "                        <i class=\"ico-append fa fa-map-o\"></i>\n" +
                        "                        <input type=\"text\" placeholder=\"Luogo di Residenza\" name=\"LuogoResidenza\" >\n" +
                        "                    </label>\n" +
                        "                </div>\n" +
                        "\n" +
                        "                <div class=\"col-md-auto mt-6\">\n" +
                        "                    <h4>Provincia: </h4>\n" +
                        "                </div>\n" +
                        "\n" +
                        "                <div class=\"col-md-1\">\n" +
                        "                    <label class=\"input\">\n" +
                        "                        <input type=\"text\" class=\"masked\" data-format=\"aa\" data-placeholder=\"X\" placeholder=\"XX\"\n" +
                        "                               name=\"ProvinciaResidenza\" >\n" +
                        "                    </label>\n" +
                        "                </div>\n" +
                        "\n" +
                        "            </div>\n" +
                        "\n" +
                        "            <div class=\"row pr-15 mb-35\">\n" +
                        "                <div class=\"col-md-auto mt-6 pr-0\">\n" +
                        "                    <h4>Codice Fiscale: </h4>\n" +
                        "                </div>\n" +
                        "\n" +
                        "                <div class=\"col\">\n" +
                        "                    <label class=\"input mb-20\">\n" +
                        "                        <input type=\"text\" class=\"masked\" data-format=\"****************\" data-placeholder=\"X\"\n" +
                        "                               placeholder=\"Codice Fiscale\" name=\"CodiceFiscale\" >\n" +
                        "                    </label>\n" +
                        "                </div>\n" +
                        "\n" +
                        "                <div class=\"col-md-auto mt-6 pr-0\">\n" +
                        "                    <h4>Numero di Telefono: </h4>\n" +
                        "                </div>\n" +
                        "\n" +
                        "                <div class=\"col\">\n" +
                        "                    <label class=\"input mb-20\">\n" +
                        "                        <i class=\"ico-append fa fa-phone\"></i>\n" +
                        "                        <input type=\"tel\"name=\"NumeroTelefono\" >\n" +
                        "                    </label>\n" +
                        "                </div>\n" +
                        "\n" +
                        "            </div>\n" +
                        "\n" +
                        "            <h4 class=\"text-center mb-10 mt-30\">Attuale condizione :</h4>\n" +
                        "            <h5 class=\"text-center fs-16 mb-30\">(barrare la casella e compila la casella di testo a fianco &ndash;\n" +
                        "                possibilit&agrave; di doppia scelta)</h5>\n" +
                        "\n" +
                        "            <div class=\"row pr-15 pl-15 pr-15\">\n" +
                        "                <label class=\"checkbox mt-6\">\n" +
                        "                    <input type=\"checkbox\" name=\"CKStudenteCorsoLaurea\" value=\"1\">\n" +
                        "                    <i></i> Studente Corso di Laurea in:\n" +
                        "                </label>\n" +
                        "\n" +
                        "                <label class=\"input col\">\n" +
                        "                    <input type=\"text\" placeholder=\"Corso di Laurea\" name=\"StudenteCorsoLaurea\">\n" +
                        "                </label>\n" +
                        "            </div>\n" +
                        "\n" +
                        "            <div class=\"row pl-15 pr-15\">\n" +
                        "                <label class=\"checkbox mt-6\">\n" +
                        "                    <input type=\"checkbox\" name=\"CKDiplomaUniversitario\" value=\"1\">\n" +
                        "                    <i></i> Diplomato. Diploma universitario in <em class=\"fw-100\">(entro 12 mesi dal diploma)</em>\n" +
                        "                    &nbsp;:\n" +
                        "                </label>\n" +
                        "                <label class=\"input col\">\n" +
                        "                    <input type=\"text\" placeholder=\"Diploma universitario\" name=\"DiplomaUniversitario\">\n" +
                        "                </label>\n" +
                        "            </div>\n" +
                        "\n" +
                        "            <div class=\"row pl-15 pr-15\">\n" +
                        "                <label class=\"checkbox mt-6\">\n" +
                        "                    <input type=\"checkbox\" name=\"CKLaureaIn\" value=\"1\">\n" +
                        "                    <i></i> Laureato. Laurea in <em class=\"fw-100\">(entro 12 mesi dalla laurea)</em> &nbsp;:\n" +
                        "                </label>\n" +
                        "                <label class=\"input col\">\n" +
                        "                    <input type=\"text\" placeholder=\"Corso di Laurea\" name=\"LaureaIn\">\n" +
                        "                </label>\n" +
                        "            </div>\n" +
                        "\n" +
                        "            <div class=\"row pl-15 pr-15\">\n" +
                        "                <label class=\"checkbox mt-6\">\n" +
                        "                    <input type=\"checkbox\" name=\"CKDottoratoRicerca\" value=\"1\">\n" +
                        "                    <i></i> Dottorato di ricerca in:\n" +
                        "                </label>\n" +
                        "                <label class=\"input col\">\n" +
                        "                    <input type=\"text\" placeholder=\"Corso di Laurea\" name=\"DottoratoRicerca\">\n" +
                        "                </label>\n" +
                        "            </div>\n" +
                        "\n" +
                        "            <div class=\"row pl-15 pr-15\">\n" +
                        "                <label class=\"checkbox mt-6 pr-0\">\n" +
                        "                    <input type=\"checkbox\" name=\"CKScuolaAltro\" value=\"1\">\n" +
                        "                    <i></i> Scuola o corso di perfezionamento o specializzazione in:\n" +
                        "                </label>\n" +
                        "                <label class=\"input col\">\n" +
                        "                    <input type=\"text\" placeholder=\"Corso di Laurea\" name=\"ScuolaAltro\">\n" +
                        "                </label>\n" +
                        "            </div>\n" +
                        "\n" +
                        "\n" +
                        "            <div class=\"row mb-100 mt-80\">\n" +
                        "                <div class=\"col-md-auto mt-4\">\n" +
                        "                    <h4>Barrare se trattasi di soggetto portatore di handicap:</h4>\n" +
                        "                </div>\n" +
                        "                <div class=\"col-md-auto\">\n" +
                        "                    <label class=\"checkbox mt-6 pr-0\">\n" +
                        "                        <input type=\"checkbox\" name=\"Handicap\" value=\"Si\">\n" +
                        "                        <i></i> SI\n" +
                        "                    </label>\n" +
                        "                    <label class=\"checkbox mt-6 pr-0\">\n" +
                        "                        <input type=\"checkbox\" name=\"Handicap\" value=\"NO\">\n" +
                        "                        <i></i> NO\n" +
                        "                    </label>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "\n" +
                        "        </fieldset>");
                }
                $("#Tirocinante").fadeIn("slow");
                $("fieldset[name='Tirocinante']").animate({
                    opacity: 1,
                    height: "show",
                    marginBottom: "50px"
                }, 1000);


            } else {
                $("#Tirocinante").fadeOut();
                $("fieldset[name='Tirocinante']").animate({
                    opacity: 0,
                    height: "hide"
                }, 1000);
                if ($("#Ente-Azienda").length) {
                    console.log("esiste");
                } else {
                    $("fieldset[name='Accesso']").after("<header class=\"mb-50 fs-50 fw-100 text-center\" style=\"display:none;\">Crea Il Tuo Account</header>\n" +
                        "\n" +
                        "        <div id=\"Ente-Azienda\" class=\"header-form mb-30\"><i class=\"fa fa-balance-scale\"></i>&nbsp; INFORMAZIONI ENTE /\n" +
                        "            AZIENDA\n" +
                        "        </div>\n" +
                        "        <fieldset name=\"Ente-Azienda\" style=\"display:none;\">\n" +
                        "\n" +
                        "            <div class=\"row\">\n" +
                        "                <div class=\"col-md-auto mt-6\">\n" +
                        "                    <h4>L’Ente/Azienda:&nbsp;</h4>\n" +
                        "                </div>\n" +
                        "                <div class=\"col\">\n" +
                        "                    <label class=\"input\">\n" +
                        "                        <input type=\"text\" placeholder=\"Nome Ente / Azienda\" name=\"NomeAzienda\" >\n" +
                        "                    </label>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "\n" +
                        "            <div class=\"row\">\n" +
                        "                <div class=\"col-md-auto mt-6\">\n" +
                        "                    <h4>Con sede legale in (indirizzo): &nbsp;</h4>\n" +
                        "                </div>\n" +
                        "                <div class=\"col\">\n" +
                        "                    <label class=\"input\">\n" +
                        "                        <input type=\"text\" placeholder=\"Indirizzo sede legale\" name=\"SedeLegale\" >\n" +
                        "                    </label>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "\n" +
                        "            <div class=\"row\">\n" +
                        "                <div class=\"col-md-auto mt-6\">\n" +
                        "                    <h4>Codice Fiscale (o Partita IVA): &nbsp;</h4>\n" +
                        "                </div>\n" +
                        "                <div class=\"col\">\n" +
                        "                    <label class=\"input\">\n" +
                        "                        <input type=\"text\" placeholder=\"Codice Fiscale o Partita IVA\" name=\"PartitaIVA\" >\n" +
                        "                    </label>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "            <div class=\"row\">\n" +
                        "                <div class=\"col-auto mt-6\">\n" +
                        "                    <h4>Rappresentato da: &nbsp;</h4>\n" +
                        "                </div>\n" +
                        "                <div class=\"col\">\n" +
                        "                    <div class=\"row\">\n" +
                        "                        <div class=\"col-md-6\">\n" +
                        "                            <label class=\"input\">\n" +
                        "                                <input type=\"text\" placeholder=\"Nome Rappresentante Aziendale\" name=\"NomeRappresentante\"\n" +
                        "                                       >\n" +
                        "                            </label>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"col-md-6\">\n" +
                        "                            <label class=\"input\">\n" +
                        "                                <input type=\"text\" placeholder=\"Cognome Rappresentante Aziendale\"\n" +
                        "                                       name=\"CognomeRappresentante\" >\n" +
                        "                            </label>\n" +
                        "                        </div>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "            <div class=\"row\">\n" +
                        "                <div class=\"col-md-auto mt-6\">\n" +
                        "                    <h4>Nominativo responsabile dei tirocini: &nbsp;</h4>\n" +
                        "                </div>\n" +
                        "                <div class=\"col\">\n" +
                        "                    <div class=\"row\">\n" +
                        "                        <div class=\"col-md-6\">\n" +
                        "                            <label class=\"input\">\n" +
                        "                                <input type=\"text\" placeholder=\"Nome Responsabile\" name=\"NomeResponsabile\" >\n" +
                        "                            </label>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"col-md-6\">\n" +
                        "                            <label class=\"input\">\n" +
                        "                                <input type=\"text\" placeholder=\"Cognome Responsabile\" name=\"CognomeResponsabile\"\n" +
                        "                                       >\n" +
                        "                            </label>\n" +
                        "                        </div>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "            <div class=\"row\">\n" +
                        "                <div class=\"col-md-auto mt-6\">\n" +
                        "                    <h4>Numero di telefono del responsabile dei tirocini: &nbsp;</h4>\n" +
                        "                </div>\n" +
                        "                <div class=\"col\">\n" +
                        "                    <label class=\"input\">\n" +
                        "                        <input type=\"tel\" placeholder=\"Numero di telefono\" name=\"NumeroTelefonoResponsabile\"\n" +
                        "                               >\n" +
                        "                    </label>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "            <div class=\"row\">\n" +
                        "                <div class=\"col-md-auto mt-6\">\n" +
                        "                    <h4>Indirizzo email del responsabile dei tirocini: &nbsp;</h4>\n" +
                        "                </div>\n" +
                        "                <div class=\"col-md-12 col-lg\">\n" +
                        "                    <label class=\"input\">\n" +
                        "                        <input type=\"email\" placeholder=\"Email responsabile\" name=\"EmailResponsabile\" >\n" +
                        "                    </label>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "        </fieldset>");
                }

                $("#Ente-Azienda").fadeIn("slow");
                $("fieldset[name='Ente-Azienda']").animate({
                    opacity: 1,
                    height: "show",
                    marginBottom: "50px"
                }, 1000);
            }
        });
    }

});
