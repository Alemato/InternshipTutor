<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin</title>

  <#include "../importCss.ftl">
    <!-- Page Sript -->
    <link href="css/admin.css" rel="stylesheet" type="text/css"/>
    <!-- /Page Script -->

    <!-- CSS DATATABLES -->
    <link href="css/layout-datatables.css" rel="stylesheet" type="text/css"/>

</head>
<body class="smoothscroll enable-animation">

<nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse navbar-large bg-dark">
    <button class="navbar-toggler navbar-toggler-right hidden-lg-up" type="button" data-toggle="collapse"
            data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand link-bar" href="index.html">Intership Tutor </a>
    <ol class="breadcrumb">
        <li><a href="admin.html">HOME DASHBOARD</a></li>
        <li><a href="/gestione-utenti"><b>GESTIONE UTENZA</b></a></li>
        <li class="active"><a href="#"><b>GESTIONE: ${tirocinante.nome} ${tirocinante.cognome}</b></a></li>
    </ol>
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <div class="row">
                <a class="nav-link link-bar mt-5" href="#">Benvenuto, <b>ADMIN</b></a>
                <a class="nav-link link-bar text-center" href="#"><i class="fa fa-user-md fs-35 px-3"></i></a>
            </div>
        </li>
    </ul>

</nav>
<div class="container-fluid">
    <div class="row">
       <#include "../BackEndTemplates/sidebar.ftl">


        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">

            <noscript>
                <div class="alert alert-danger mb-10 mt-10">
                    <h3 class="mb-10"><strong>Attenzione!</strong></h3>
                    <p>Per motivi di usabilit&agrave; &egrave; sconsigliato l&apos;uso dei <b>javascript</b>, per tanto <b>attiva tale funzionalit&agrave; nel tuo browser!!!</b></p>
                </div>
            </noscript>

            <section class="row text-center placeholders pt-10 pb-10 mb-10">
            </section>
            <div class="col">
                <form action="/modifica-tirociante" method="post">
                    <input type="hidden" name="IDTirocinante" value="${tirocinante.IDTirocinante}">
                    <input type="hidden" name="IDUser" value="${user.IDUser}">
                    <#if ErroreGenericoUpdate??>
                        <div class="alert alert-warning mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreGenericoUpdate}
                        </div>
                    </#if>
                <div class="form-group">
                    <#if ErroreEmail??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreEmail}
                        </div>
                    </#if>
                    <label>Email</label>
                    <input type="email" <#if ErroreEmail??> class="error" </#if> name="email"   value="${user.email}">
                </div>
                <div class="form-group">
                    <#if ErrorePassword??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErrorePassword}
                        </div>
                    </#if>
                    <label>Nuova Password</label>
                    <input type="password" <#if ErrorePassword??> class="error" </#if> name="newpassword">
                </div>
                    <div class="form-group">
                        <#if ErroreConfermaPassword??>
                            <div class="alert alert-danger mb-20">
                                <button type="button" class="close" data-dismiss="alert">
                                    <span aria-hidden="true">&times;</span>
                                    <span class="sr-only">Chiudi</span>
                                </button>
                                <strong>Attenzione!</strong> ${ErroreConfermaPassword}
                            </div>
                        </#if>
                        <label>Ripeti Nuova Password </label>
                        <input type="password"  <#if ErroreConfermaPassword??> class="error" </#if> name="repaetnewpassword">
                    </div>
                    <div class="form-group">
                        <#if ErroreNome??>
                            <div class="alert alert-danger mb-20">
                                <button type="button" class="close" data-dismiss="alert">
                                    <span aria-hidden="true">&times;</span>
                                    <span class="sr-only">Chiudi</span>
                                </button>
                                <strong>Attenzione!</strong> ${ErroreNome}
                            </div>
                        </#if>
                        <label>Nome</label>
                        <input type="text" <#if ErroreNome??> class="error" </#if> name="nome" <#if ValueOfnome??> value="${ValueOfnome}" <#else> value="${tirocinante.nome}" </#if> >
                    </div>
                <div class="form-group">
                    <#if ErroreCognome??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreCognome}
                        </div>
                    </#if>
                    <label>Cognome</label>
                    <input type="text" <#if ErroreCognome??> class="error" </#if> name="cognome" <#if ValueOfcognome??>value="${ValueOfcognome}"<#else> value="${tirocinante.cognome}"</#if> >
                </div>
                <div class="form-group">
                    <#if ErroreLuogoDiNascita??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreLuogoDiNascita}
                        </div>
                    </#if>
                    <label>Luogo di nascità</label>
                    <input type="text"  <#if ErroreLuogoDiNascita??> class="error" </#if> name="luogodinascita" <#if ValueOfluogodinascita??>value="${ValueOfluogodinascita}"<#else> value="${tirocinante.luogoDiNascita}"</#if> >
                </div>
                <div class="row">
                    <#if ErroreLuogoDiResidenza??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreLuogoDiResidenza}
                        </div>
                    </#if>
                    <label>Luogo di residenza</label>
                    <input type="text" <#if ErroreLuogoDiResidenza??> class="error" </#if> name="luogodiresidenza" <#if ValueOfluogodiresidenza??> value="${ValueOfluogodiresidenza}" <#else> value="${tirocinante.luogoDiResidenza} </#if> ">
                </div>
                <div class="row">
                    <#if ErroreProvinciaDiNascita??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreProvinciaDiNascita}
                        </div>
                    </#if>
                    <label>Procincia di Nascità</label>
                    <input type="text" <#if ErroreProvinciaDiNascita??> class="error" </#if> name="provinciadinascita"<#if ValueOfprovinciadinascita??> value="${ValueOfprovinciadinascita}" <#else> value="${tirocinante.provinciaDiNascita}"</#if> >
                </div>
                <div class="row">
                    <#--TODO ciao -->
                    <#if ErroreProvinciaDiNascita??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreProvinciaDiNascita}
                        </div>
                    </#if>
                    <#if WarningDataDiNascita??>
                        <div class="alert alert-warning mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${WarningDataDiNascita}
                        </div>
                    </#if>
                    <label>Data di Nascita ${tirocinante.dataDiNascita}</label>
                    <label>Inserire nuova data di nascita</label>
                    <input type="date" name="datadinascita" >
                </div>
                <div class="row">
                    <#if ErroreProvinciaDiResidenza??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreProvinciaDiResidenza}
                        </div>
                    </#if>
                    <label>Provincia di residenza</label>
                    <input type="text" <#if ErroreProvinciaDiResidenza??> class="error" </#if> name="provinciadiresidenza" <#if ValueOfprovinciadiresidenza??> value="${ValueOfprovinciadiresidenza}" <#else> value="${tirocinante.provinciaDiResidenza}" </#if> >
                </div>
                <div class="row">
                    <#if ErroreCodiceFiscale??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreCodiceFiscale}
                        </div>
                    </#if>
                    <label>Codice Fiscale</label>
                    <input type="text"  <#if ErroreCodiceFiscale??> class="error" </#if>  name="codicefiscale" <#if ValueOfcodicefiscale??>  value="${ValueOfcodicefiscale}" <#else> value="${tirocinante.codiceFiscale}" </#if> >
                </div>
                    <div class="row">
                        <#if ErroreTelefono??>
                            <div class="alert alert-danger mb-20">
                                <button type="button" class="close" data-dismiss="alert">
                                    <span aria-hidden="true">&times;</span>
                                    <span class="sr-only">Chiudi</span>
                                </button>
                                <strong>Attenzione!</strong> ${ErroreTelefono}
                            </div>
                        </#if>
                        <label>Telefono</label>
                        <input type="text" <#if ErroreTelefono??> class="error" </#if> name="telefono" <#if ValueOftelefono??> value="${ValueOftelefono}" <#else> value="${tirocinante.telefono}"</#if> >
                    </div>

                <div class="row">
                    <#if ErroreCorsoDiLaurea??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreCorsoDiLaurea}
                        </div>
                    </#if>
                    <label>Corso di Laurea</label>
                    <input type="text" <#if ErroreCorsoDiLaurea??> class="error" </#if> name="corsodilaurea" <#if ValueOfcorsodilaurea?? > value="${ValueOfcorsodilaurea}" <#elseif tirocinante.corsoDiLaurea??> value="${tirocinante.corsoDiLaurea}" </#if> >
                </div>
                <div class="row">
                    <#if ErroreDiplomaUniversitario??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreDiplomaUniversitario}
                        </div>
                    </#if>
                    <label>Diploma Universitario</label>
                    <input type="text" <#if ErroreDiplomaUniversitario??> class="error" </#if> name="diplomauniversitario" <#if ValueOfdiplomauniversitario??> value="${ValueOfdiplomauniversitario}" <#elseif tirocinante.diplomaUniversitario?? > value="${tirocinante.diplomaUniversitario}"</#if> >
                </div>
                <div class="row">
                    <#if ErroreLaureatoUniversitario??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreLaureatoUniversitario}
                        </div>
                    </#if>
                    <label>Laurea</label>
                    <input type="text" <#if ErroreLaureatoUniversitario??> class="error" </#if>  name="laureatouniversitario" <#if ValueOflaureatouniversitario??> value="${ValueOflaureatouniversitario}" <#elseif tirocinante.laureatoUniversitario??> value="${tirocinante.laureatoUniversitario}"</#if> >
                </div>
                <div class="row">
                    <#if ErroreScuolaAltro??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreScuolaAltro}
                        </div>
                    </#if>
                    <label>Scuola o Altro </label>
                    <input type="text" <#if ErroreLaureatoUniversitario??> class="error" </#if>   name="scuolaaltro" <#if ValueOfscuolaaltro??> value="${ValueOfscuolaaltro}" <#elseif tirocinante.scuolaAltro?? >value="${tirocinante.scuolaAltro}" </#if> >
                </div>

                <div class="row">
                    <#if ErroreDottoratoDiRicerca??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreDottoratoDiRicerca}
                        </div>
                    </#if>
                    <label>Dottorato</label>
                    <input type="text"  <#if ErroreDottoratoDiRicerca??> class="error" </#if>  name="dottoratodiricerca" <#if ValueOfdottoratodiricerca??>  value="${ValueOfdottoratodiricerca}" <#elseif tirocinante.dottoratoDiRicerca?? >  value="${tirocinante.dottoratoDiRicerca}" </#if> >
                </div>
                <div class="row">
                    <label>HandiCap :  </label>
                    <input type="checkbox" name="handicap" value="1" <#if tirocinante.handicap> checked </#if>>
                </div>

                    <button type="submit" class="btn btn-primary" >Modifica</button>
                </form>

            </div>


        </main>
    </div>
</div>


<!-- JAVASCRIPT FILES -->

<!-- Script page -->




</body>
</html>
