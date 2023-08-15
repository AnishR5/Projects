using BOL;
using DAL;
using Microsoft.AspNetCore.Mvc;

namespace MovieMgmt.Controllers
{
    public class MovieController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }

        public IActionResult InsertMovie()
        {
            return View();
        }

        [HttpPost]
        public IActionResult InsertMovie(int mId,string mName,string mDescription,int mDirectorId,string cast,int mins) { 
           Movie movie=new Movie(mId,mName,mDescription,mDirectorId,cast,mins);
           bool status = DBManager.Insert(movie);
            return RedirectToAction("Index");      
        }

        public IActionResult GetAllMovies()
        {
            List<Movie> movies = DBManager.GetAll();
            ViewBag.Movies = movies;
            return View();
        }

        public IActionResult GetMovieById()
        {
            return View();
        }

        [HttpPost]
        public IActionResult GetMovieByDirectorId(int mDirectorId)
        {
            Movie m = DBManager.GetMovieByDirectorId(mDirectorId);
            ViewBag.Movie = m;
            return View();
        }

        public IActionResult DeleteById()
        {
            return View();
        }

        [HttpPost]
        public IActionResult DeleteById(int mid) { 
            bool status = DBManager.Delete(mid);
            return RedirectToAction("Index");
        }





    }


}
