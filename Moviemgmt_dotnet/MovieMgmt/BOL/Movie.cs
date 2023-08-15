namespace BOL
{
    public class Movie
    {  
      public int mId { get; set; }
      public string mName { get; set; }
      public string mDescription { get; set; }
        public int mDirectorID { get; set; } 
        public string cast { get; set; }    
        public int mins { get; set; }

    public Movie(int mId,string mName,string mDescription,int mDirectorID,string cast,int mins)
        {
            this.mId = mId;
            this.mName = mName;
            this.mDescription = mDescription;
            this.mDirectorID = mDirectorID;
            this.cast = cast;
            this.mins = mins;
        }

        public Movie()
        { }
    }

   
}