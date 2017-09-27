package com

package object htmlism {
  type Registry = Int

  implicit val dependencyRegistry: Registry = 12345
}
