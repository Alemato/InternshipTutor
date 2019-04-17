<nav class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar bg-light">
    <div class="side-nav mb-60">
        <ul class="list-group list-group-bordered list-group-noicon uppercase">
            <li><a href="/admin">HOME DASHBOARD</a></li>
            <li<#if url == "/admin/gestione-tirocinanti" ||  url == "/admin/gestione-aziende" || url == "/admin/gestione-tutoti" ||  url == "/admin/gestione-admin"> class="list-group-item active"<#else> class="list-group-item" </#if> >
                <a   class="dropdown-toggle"  > GESTIONE UTENZA</a>
                <ul>
                    <li <#if url == "/admin/gestione-tirocinanti" >class="active"</#if> ><a href="/admin/gestione-tirocinanti">TIROCINANTI</a></li>
                    <li <#if url == "/admin/gestione-aziende" >class="active"</#if> ><a href="/admin/gestione-aziende">AZIENDE</a></li>
                    <li <#if url == "/admin/gestione-tutoti" >class="active"</#if> ><a href="/admin/gestione-tutoti">TUTORI</a></li>
                    <li <#if url == "/admin/gestione-admin" >class="active"</#if> ><a href="/admin/gestione-admin">ADMIN</a></li>
                </ul>
            </li>
            <li <#if url == "/admin/richisteconvezioni"> class="active" </#if> >
                <a href="/admin/richisteconvezioni"> GESTIONE RICHIESTE CONVENZIONE </a>
            </li>
            <li <#if url=="/admin/offertetirocinioadmin"> class="active" </#if> >
                <a href="/admin/offertetirocinioadmin"> OFFERTE DI TIROCINIO </a>
            </li>
            <li <#if url=="/admin/Gestione-tirocinio" || url=="/admin/Gestione-Convenzione" > class="list-group-item active" <#else> class="list-group-item" </#if> >
                <a class="dropdown-toggle" > GESTIONE MODULI </a>
                <ul>
                    <li <#if url=="/admin/Gestione-tirocinio"> class="active" </#if> ><a href="/admin/Gestione-tirocinio">GESTIONE MODULI TIROCINI</a></li>
                    <li <#if url=="/admin/Gestione-Convenzione"> class="active" </#if> ><a href="/admin/Gestione-Convenzione">GESTIONE CONVENZIONI AZIENDALI</a>
                    </li>
                </ul>
            </li>

            <li><a href="#">IMPOSTAZIONI ACCOUNT</a></li>
            <li class=""><a href="/logout">LOGOUT</a></li>

        </ul>
    </div>
</nav>