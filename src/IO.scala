import java.io.{File, PrintWriter}

/**
  * Created by neo on 09.10.16.
  */
object IO {

  def createFileWriter(fname: String): PrintWriter = {
    new PrintWriter(new File(fname))
  }

}
