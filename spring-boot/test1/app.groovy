@RestController
class HomeController{

    @RequestMapping("/")
    String home(){
        "C’est une belle journée pour faire du Spring boot !"
    }

    @RequestMapping("/hello")
    String home(@RequestParam String name){
        "Salut, $name"
    }
}