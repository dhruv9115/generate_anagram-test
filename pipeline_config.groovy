jte{
// restrict individual repository Jenkinsfiles
    //allow_scm_jenkinsfile = false
}
// define application environment objects
application_environments{
    dev{
        long_name = "Development"
    }
    prod{
        long_name = "Production"
    }
}

/*
  define libraries to load.
  available libraries are based upon the
  library sources configured.
*/
libraries{
    git
    maven
}