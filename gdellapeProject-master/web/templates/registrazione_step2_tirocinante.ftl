<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Registrazione - Parte 2</title>

    <#include "importCss.ftl">
</head>
<body class="enable-animation">

<div class="w-1000 mx-auto">
    <form id="form_registrazione" action="/registrazione" method="post" class="sky-form validate boxed">

        <header class="mb-50 fs-50 fw-100 text-center">Crea Il Tuo Account</header>

        <div id="Tirocinante" class="header-form mb-30"><i class="fa fa-user"></i> INFORMAZIONI
            PERSONALI TIROCINANTE
        </div>
        <fieldset name="step-1" class="d-none">
            <input type="hidden" name="Email" value=${email}>
            <input type="password" class="d-none" name="Password" value=${password}>
            <input type="hidden" name="Tipologia" value="Tirocinante">
        </fieldset>
        <fieldset name="Tirocinante">
            <div class="row pr-15 mb-35">
                <div class="col-md-auto mt-6 pr-0">
                    <h4>Nominativo del tirocinante: </h4>
                </div>
                <div class="col">
                    <label class="input">
                        <input type="text" placeholder="Nome" name="Nome" required>
                    </label>
                </div>
                <div class="col col">
                    <label class="input">
                        <input type="text" placeholder="Cognome" name="Cognome" required>
                    </label>
                </div>
            </div>

            <div class="row pr-15 mb-35">
                <div class="col-md-auto mt-6">
                    <h4>Nato a:</h4>
                </div>

                <div class="col">
                    <label class="input">
                        <i class="ico-append fa fa-map-o"></i>
                        <input type="text" placeholder="Luogo di Nascita" name="LuogoNascita" required>
                    </label>
                </div>

                <div class="col-md-auto mt-6">
                    <h4>Provincia: </h4>
                </div>

                <div class="col-md-1">
                    <label class="input">
                        <input type="text" class="masked" data-format="aa" placeholder="XX" name="ProvinciaNascita"
                               required>
                    </label>
                </div>


                <div class="col-md-auto mt-6">
                    <h4>Il: </h4>
                </div>

                <div class="col">
                    <label class="input">
                        <i class="ico-append fa fa-calendar"></i>
                        <input type="text" class="masked" data-format="99 / 99 / 9999" data-placeholder="X"
                               placeholder="GG / MM / ANNO" name="DataNascita" required>
                    </label>
                </div>
            </div>

            <div class="row pr-15 mb-35">
                <div class="col-md-auto mt-6 pr-0">
                    <h4>Residente in: </h4>
                </div>

                <div class="col">
                    <label class="input">
                        <i class="ico-append fa fa-map-o"></i>
                        <input type="text" placeholder="Luogo di Residenza" name="LuogoResidenza" required>
                    </label>
                </div>

                <div class="col-md-auto mt-6">
                    <h4>Provincia: </h4>
                </div>

                <div class="col-md-1">
                    <label class="input">
                        <input type="text" class="masked" data-format="aa" data-placeholder="X" placeholder="XX"
                               name="ProvinciaResidenza" required>
                    </label>
                </div>

            </div>

            <div class="row pr-15 mb-35">
                <div class="col-md-auto mt-6 pr-0">
                    <h4>Codice Fiscale: </h4>
                </div>

                <div class="col">
                    <label class="input mb-20">
                        <input type="text" class="masked" data-format="****************" data-placeholder="X"
                               placeholder="Codice Fiscale" name="CodiceFiscale" required>
                    </label>
                </div>

                <div class="col-md-auto mt-6 pr-0">
                    <h4>Numero di Telefono: </h4>
                </div>

                <div class="col">
                    <label class="input mb-20">
                        <i class="ico-append fa fa-phone"></i>
                        <input type="text" class="masked" data-format="999-9999999" data-placeholder="XXX-XXXXXXX"
                               placeholder="Numero di telefono" name="NumeroTelefono" required>
                    </label>
                </div>

            </div>

            <h4 class="text-center mb-10 mt-30">Attuale condizione :</h4>
            <h5 class="text-center fs-16 mb-30">(barrare la casella e compila la casella di testo a fianco &ndash;
                possibilit&agrave; di doppia scelta)</h5>

            <div class="row pr-15 pl-15 pr-15">
                <label class="checkbox mt-6">
                    <input type="checkbox" name="CKStudenteCorsoLaurea" value="1">
                    <i></i> Studente Corso di Laurea in:
                </label>

                <label class="input col">
                    <input type="text" placeholder="Corso di Laurea" name="StudenteCorsoLaurea">
                </label>
            </div>

            <div class="row pl-15 pr-15">
                <label class="checkbox mt-6">
                    <input type="checkbox" name="CKDiplomaUniversitario" value="1">
                    <i></i> Diplomato. Diploma universitario in <em class="fw-100">(entro 12 mesi dal diploma)</em>
                    &nbsp;:
                </label>
                <label class="input col">
                    <input type="text" placeholder="Diploma universitario" name="DiplomaUniversitario">
                </label>
            </div>

            <div class="row pl-15 pr-15">
                <label class="checkbox mt-6">
                    <input type="checkbox" name="CKLaureaIn" value="1">
                    <i></i> Laureato. Laurea in <em class="fw-100">(entro 12 mesi dalla laurea)</em> &nbsp;:
                </label>
                <label class="input col">
                    <input type="text" placeholder="Corso di Laurea" name="LaureaIn">
                </label>
            </div>

            <div class="row pl-15 pr-15">
                <label class="checkbox mt-6">
                    <input type="checkbox" name="CKDottoratoRicerca" value="1">
                    <i></i> Dottorato di ricerca in:
                </label>
                <label class="input col">
                    <input type="text" placeholder="Corso di Laurea" name="DottoratoRicerca">
                </label>
            </div>

            <div class="row pl-15 pr-15">
                <label class="checkbox mt-6 pr-0">
                    <input type="checkbox" name="CKScuolaAltro" value="1">
                    <i></i> Scuola o corso di perfezionamento o specializzazione in:
                </label>
                <label class="input col">
                    <input type="text" placeholder="Corso di Laurea" name="ScuolaAltro">
                </label>
            </div>


            <div class="row mb-100 mt-80">
                <div class="col-md-auto mt-4">
                    <h4>Barrare se trattasi di soggetto portatore di handicap:</h4>
                </div>
                <div class="col-md-auto">
                    <label class="checkbox mt-6 pr-0">
                        <input type="checkbox" name="Handicap" value="Si">
                        <i></i> SI
                    </label>
                    <label class="checkbox mt-6 pr-0">
                        <input type="checkbox" name="Handicap" value="NO">
                        <i></i> NO
                    </label>
                </div>
            </div>

        </fieldset>


        <footer>
            <button type="submit" form="form_registrazione" class="btn btn-success btn-lg pull-right float-right"><i
                    class="fa fa-check"></i> Crea il tuo Account
            </button>
            <a href="/registration">
            <button type="button" form="form_registrazione" class="btn btn-red btn-lg pull-right float-left"><i
                    class="fa fa-times"></i> Annulla
            </button>
            </a>
        </footer>

    </form>
</div>
<!-- JAVASCRIPT FILES -->
<#include "importScript.ftl">

</body>
</html>
