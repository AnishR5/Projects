using BOL;
using MySql.Data.MySqlClient;


namespace DAL
{
    public class DBManager
    {
        public static string conString = @"server=localhost;port=3306;user=root;password=root123;database=dotnet";


        public static bool Insert(Movie movie)
        {
            bool status = false;
            MySqlConnection conn = new MySqlConnection();
            conn.ConnectionString = conString;
            Console.WriteLine("inside insert");

            try
            {
                conn.Open();
                string query = "insert into movie values (" + movie.mId + ",'" + movie.mName + "','" + movie.mDescription + "'," + movie.mDirectorID + ",'" + movie.cast + "'," + movie.mins + ")";
                MySqlCommand cmd = new MySqlCommand(query, conn);
                Console.WriteLine("inside insert");
                cmd.ExecuteNonQuery();
                status = true;

            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally { conn.Close(); }
            return status;
        }

        public static List<Movie> GetAll()
        {
            List<Movie> list = new List<Movie>();
            MySqlConnection conn = new MySqlConnection();
            conn.ConnectionString = conString;

            try
            {
                conn.Open();
                string query = "select * from movie";
                MySqlCommand cmd = new MySqlCommand(query, conn);
                MySqlDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    int mId = int.Parse(reader["mId"].ToString());
                    string mName = reader["mName"].ToString();
                    string mDesc = reader["mDescription"].ToString();
                    int mDirectorId = int.Parse(reader["mDirectorId"].ToString());
                    string cast = reader["cast"].ToString();
                    int mins = int.Parse(reader["mins"].ToString());
                    Movie m = new Movie(mId, mName, mDesc, mDirectorId, cast, mins);
                    list.Add(m);
                }

            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally { conn.Close(); }

            return list;
        }

        public static Movie GetMovieByDirectorId(int id)
        {
            Movie movie = null;
            MySqlConnection conn = new MySqlConnection();
            conn.ConnectionString = conString;

            try
            {
                conn.Open();
                string query = "select * from movie where mDirectorId=" + id + ")";
                MySqlCommand cmd = new MySqlCommand(query, conn);
                MySqlDataReader reader = cmd.ExecuteReader();

                int mId = int.Parse(reader["mId"].ToString());
                string mName = reader["mName"].ToString();
                string mDesc = reader["mDescription"].ToString();
                int mDirectorId = int.Parse(reader["mDirectorId"].ToString());
                string cast = reader["cast"].ToString();
                int mins = int.Parse(reader["mins"].ToString());
                 movie = new Movie(mId, mName, mDesc, mDirectorId, cast, mins);


            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally { conn.Close(); }
            return movie;


        }

        public static bool Delete(int movieId)
        {
            bool status = false;
            MySqlConnection connection = new MySqlConnection();
            connection.ConnectionString = conString;
            try
            {
                string query = "delete from movie where mId=" + movieId;
                connection.Open();
                MySqlCommand cmd = new MySqlCommand(query, connection);
                int rowsaffected = cmd.ExecuteNonQuery();
                status = rowsaffected > 0;
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
            finally
            {
                connection.Close();
            }
            return status;
        }



    }
}