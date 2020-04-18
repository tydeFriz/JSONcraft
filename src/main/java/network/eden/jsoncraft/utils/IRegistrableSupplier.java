package network.eden.jsoncraft.utils;

import java.util.function.Supplier;
import javax.annotation.Nonnull;
import network.eden.jsoncraft.init.Registor;

public interface IRegistrableSupplier<T> {

	/**
	 * Generate a Supplier that uses that specific registrar
	 *
	 * @param registrar {@link Registor} used to retrieve registered items and blocks
	 * @return The generated supplier
	 */
	@Nonnull
	Supplier<T> makeSupplier(@Nonnull Registor registrar);
}
