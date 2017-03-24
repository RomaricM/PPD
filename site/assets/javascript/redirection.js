
var cpt = 2 ;
var x ;
 
function decompte()
{
    if(cpt>=0)
    {
        if(cpt>1){
            var sec = " secondes.";
        } 
		
		else {
            var sec = " seconde.";
        }
        document.getElementById("chrono").innerHTML = "Redirection dans " + cpt + sec ;
        cpt-- ;
        x = setTimeout(decompte,1000) ;
    }
    else
    {
        clearTimeout(x) ;
    }
}
