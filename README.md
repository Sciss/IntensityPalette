## IntensityPalette

### statement

IntensityPalette is a Java library providing a colour palette optimised for displaying intensities, such as spectral energy. It was adopted from Niklas Werner's [SonaSound](http://sonasound.sourceforge.net/) project. He took a psychooptically balanced 68-color palette developed by Klaus Hobohm and used spline interpolation to generate a resolution of 1073 distinct tones.

This library is (C)opyright 2013–2020 by Hanns Holger Rutz. All rights reserved. It is released under a [BSD-style License](https://raw.github.com/Sciss/IntensityPalette/main/LICENSE) and comes with absolutely no warranties. To contact the author, send an email to `contact at sciss.de`.

#### linking to the library

The library is available from Maven Central with the following artifact identifier:

    "de.sciss" % "intensitypalette" % "1.0.1"

### building

The project uses sbt for building. A demo class is included which can be run through

    $ sbt test:run

#### usage

The colors are provided through a static method `de.sciss.intensitypalette.IntensityPalette.apply(float intensity)` where `intensity` is expected to be in the inclusive interval `0 ... 1` (the value will be safely clipped), where `0` corresponds to lowest intensity (black) and `1` corresponds to highest intensity (white).

Values are given as 24-bit RGB (`0xRRGGBB`). In AWT/Swing, you can create a color instance via `new java.awt.Color(IntensityPalette.apply(i))`.
