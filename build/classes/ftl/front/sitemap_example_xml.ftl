<?xml version="1.0" encoding="UTF-8" ?> 
<urlset xmlns="http://www.sitemaps.org/schemas/sitemap/0.9"
xmlns:mobile="http://www.baidu.com/schemas/sitemap-mobile/1/"> 
<#if PlotList??>
<#list PlotList as Plot>
<url> 
<loc>${indexpath}/${Plot.animatedID}/${Plot.whichEpisode}.html</loc> 
<mobile:mobile type="mobile"/>
</url> 
<url> 
<loc>${indexpath}/${Plot.animatedID}/${Plot.whichEpisode}.html</loc> 
<mobile:mobile type="pc,mobile"/>
</url> 
<url> 
<loc>${indexpath}/${Plot.animatedID}/${Plot.whichEpisode}.html</loc> 
<mobile:mobile type="htmladapt"/>
</url>	
</#list>
</#if>
</urlset>